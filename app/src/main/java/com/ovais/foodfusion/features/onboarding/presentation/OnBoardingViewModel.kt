package com.ovais.foodfusion.features.onboarding.presentation

import androidx.lifecycle.ViewModel
import com.ovais.foodfusion.features.onboarding.domain.CanRouteToHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val canRouteToHomeUseCase: CanRouteToHomeUseCase
) : ViewModel() {

    private var canMoveToHome = false

    init {
        canRouteToHome()
    }

    private fun canRouteToHome() {
        canMoveToHome = canRouteToHomeUseCase()
    }

    fun startCooking() {
        if (canMoveToHome) {

        }
    }
}