package com.ovais.foodfusion.managers

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ManagerModule {
    @Binds
    fun bindLocalStorageManager(
        default: DefaultLocalStorageManager
    ): LocalStorageManager
}