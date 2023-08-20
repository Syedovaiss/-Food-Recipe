package com.ovais.foodfusion.network

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Provider

interface NetworkClientProvider : Provider<Retrofit>

class DefaultNetworkClientProvider @Inject constructor(
    private val okHttpClientProvider: OkHttpClientProvider,
    private val networkConverter: NetworkConverter
) : NetworkClientProvider {

    private val BASE_URL by lazy {
        "https://www.themealdb.com/api/json/v1/1/"
    }

    override fun get(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClientProvider.get())
            .addConverterFactory(networkConverter.get())
            .build()
    }
}