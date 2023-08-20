package com.ovais.foodfusion.features.home.di

import com.ovais.foodfusion.features.home.data.HomeRepository
import com.ovais.foodfusion.features.home.domain.CategoriesUseCase
import com.ovais.foodfusion.features.home.domain.DefaultCategoriesUseCase
import com.ovais.foodfusion.features.home.domain.DefaultHomeRepository
import com.ovais.foodfusion.features.home.service.HomeApiService
import com.ovais.foodfusion.network.NetworkClientProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface HomeModule {

    @Binds
    fun bindHomeRepository(
        default: DefaultHomeRepository
    ): HomeRepository

    @Binds
    fun bindCategoryUseCase(
        default: DefaultCategoriesUseCase
    ): CategoriesUseCase
}

@Module
@InstallIn(ViewModelComponent::class)
class HomeNetworkModule {

    @Provides
    fun providesHomeApiService(
        networkClientProvider: NetworkClientProvider
    ) = networkClientProvider.get().create(HomeApiService::class.java)
}