package com.ovais.foodfusion.application

import com.ovais.foodfusion.common.navigation.DefaultNavigationDataProvider
import com.ovais.foodfusion.common.navigation.NavigationDataProvider
import com.ovais.foodfusion.managers.LocalStorageManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    @Provides
    fun providesNavigationDataProvider(
        localStorageManager: LocalStorageManager
    ): NavigationDataProvider = DefaultNavigationDataProvider(localStorageManager)
}