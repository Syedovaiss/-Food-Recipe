package com.ovais.foodfusion.network

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    fun bindNetworkConverter(
        default: DefaultNetworkConverter
    ): NetworkConverter

    @Binds
    fun bindChuckerInterceptor(
        default: DefaultChuckerInterceptorProvider
    ): ChuckerInterceptorProvider

    @Binds
    fun bindOkHttpClientProvider(
        default: DefaultOkHttpClientProvider
    ): OkHttpClientProvider

    @Binds
    fun bindNetworkClientProvider(
        default: DefaultNetworkClientProvider
    ): NetworkClientProvider

}

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkProviderModule {

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
            explicitNulls = false
            encodeDefaults = true
        }
    }
}
