package com.ovais.foodfusion.network

import com.chuckerteam.chucker.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Provider

interface OkHttpClientProvider : Provider<OkHttpClient>

class DefaultOkHttpClientProvider @Inject constructor(
    private val chuckerInterceptorProvider: ChuckerInterceptorProvider
) : OkHttpClientProvider {

    companion object {
        private const val TIMEOUT = 30L
    }

    private val loggingLevel by lazy {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    override fun get(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(chuckerInterceptorProvider.get())
            .addNetworkInterceptor(
                HttpLoggingInterceptor().apply {
                    level = loggingLevel
                }
            )
            .build()
    }
}