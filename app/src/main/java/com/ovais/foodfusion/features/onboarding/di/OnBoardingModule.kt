package com.ovais.foodfusion.features.onboarding.di

import com.ovais.foodfusion.features.onboarding.domain.CanRouteToHomeUseCase
import com.ovais.foodfusion.features.onboarding.domain.DefaultCanRouteToHomeUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface OnBoardingModule {
    @Binds
    fun bindCanRouteToHomeUseCase(
        default: DefaultCanRouteToHomeUseCase
    ): CanRouteToHomeUseCase
}