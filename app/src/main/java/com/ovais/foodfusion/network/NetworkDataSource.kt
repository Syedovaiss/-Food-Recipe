package com.ovais.foodfusion.network

import android.util.Log
import com.ovais.foodfusion.utils.default
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.io.IOException

interface NetworkDataSource {
    suspend fun <T> execute(
        apiFunction: suspend () -> T
    ): RepoResult<T> =
        callApi { apiFunction.invoke() }
}

private suspend inline fun <T> callApi(
    crossinline apiFunction: suspend () -> T
): RepoResult<T> =
    try {
        val data = apiFunction.invoke()
        if (data == null) {
            RepoResult.Failure(ErrorResponse(HttpError.Empty))
        } else {
            RepoResult.Success(data)
        }
    } catch (exception: Exception) {
        when (exception) {
            is IOException -> RepoResult.getNetworkFailure()
            is HttpException -> RepoResult.getFailureFromException(exception)
            else -> RepoResult.technicalFailure()
        }
    }


@kotlinx.serialization.Serializable
data class ErrorResponse(
    val timestamp: String?,
    val status: String?,
    private val message: String?,
    val statusCode: Int?,
    val errors: List<String>?
) {

    val errorMessage: String
        get() = message.default()

    constructor(apiError: HttpError) : this(
        message = apiError.message,
        statusCode = apiError.code,
        status = apiError.message,
        timestamp = System.currentTimeMillis().toString(),
        errors = listOf(apiError.message)
    )

    constructor(message: String, statusCode: Int) : this(
        message = message,
        statusCode = statusCode,
        status = message,
        timestamp = System.currentTimeMillis().toString(),
        errors = listOf(message)
    )
}

sealed class RepoResult<out T> {
    data class Success<out T>(val data: T) : RepoResult<T>()
    data class Failure(val error: ErrorResponse) : RepoResult<Nothing>()

    companion object {
        fun technicalFailure(): Failure =
            Failure(ErrorResponse(HttpError.Exception))

        fun getNetworkFailure(message: String = HttpError.NoInternet.message): Failure =
            Failure(ErrorResponse(message, HttpError.NoInternet.code))

        fun getFailureFromException(exception: HttpException): Failure {
            return try {
                val errorResponseBody = exception.response()?.errorBody()
                val errorResponse = parseJson<ErrorResponse>(errorResponseBody?.string())
                errorResponse?.let { error ->
                    if (errorResponse.errorMessage.isNotEmpty()) {
                        Failure(
                            ErrorResponse(
                                error.errorMessage,
                                error.statusCode ?: exception.code()
                            )
                        )
                    } else {
                        technicalFailure()
                    }
                } ?: run {
                    Failure(
                        ErrorResponse(
                            exception.message.toString(),
                            exception.code()
                        )
                    )
                }
            } catch (e: Exception) {
                Log.e("API ERROR:", e.stackTraceToString())
                Failure(
                    ErrorResponse(
                        HttpError.Exception.message,
                        exception.code()
                    )
                )
            }
        }
    }
}


sealed class HttpError(override val code: Int, override val message: String) :
    HttpStatus(code, message) {
    object Exception : HttpError(506, "Something went wrong, please try again later!")
    object NoInternet : HttpError(501, "There's no internet connection!")
    object Empty : HttpError(400, "No data found!")
}

sealed class HttpStatus(open val code: Int, open val message: String) {
    object NoContent : HttpStatus(204, "No Content error")
    object Ok : HttpStatus(200, "Success")
}

@OptIn(ExperimentalSerializationApi::class)
inline fun <reified T> parseJson(json: String?): T? =
    json?.let {
        val jsonFormat = Json {
            ignoreUnknownKeys = true
            explicitNulls = false
            encodeDefaults = true
        }
        jsonFormat.decodeFromString(json)
    }
