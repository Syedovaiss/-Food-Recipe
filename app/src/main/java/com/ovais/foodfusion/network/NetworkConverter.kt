package com.ovais.foodfusion.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import javax.inject.Inject
import javax.inject.Provider

interface NetworkConverter : Provider<Converter.Factory>

class DefaultNetworkConverter @Inject constructor(
    private val json: Json
) : NetworkConverter {
    companion object {
        private const val MEDIA_TYPE = "application/json"
    }
    @OptIn(ExperimentalSerializationApi::class)
    override fun get(): Converter.Factory = json.asConverterFactory(MEDIA_TYPE.toMediaType())
}