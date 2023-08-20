package com.ovais.foodfusion.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import javax.inject.Inject
import javax.inject.Provider

interface ChuckerInterceptorProvider : Provider<Interceptor>

class DefaultChuckerInterceptorProvider @Inject constructor(
    @ApplicationContext private val context: Context
) : ChuckerInterceptorProvider {
    private val chuckerCollector: ChuckerCollector by lazy {
        ChuckerCollector(
            context = context,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )
    }

    override fun get(): Interceptor {
        return ChuckerInterceptor
            .Builder(context)
            .collector(chuckerCollector)
            .alwaysReadResponseBody(true)
            .build()
    }
}