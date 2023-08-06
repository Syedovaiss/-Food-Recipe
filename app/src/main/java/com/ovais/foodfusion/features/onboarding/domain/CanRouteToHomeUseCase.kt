package com.ovais.foodfusion.features.onboarding.domain

import com.ovais.foodfusion.managers.LocalStorageManager
import javax.inject.Inject

interface CanRouteToHomeUseCase {
    operator fun invoke():Boolean
}

class DefaultCanRouteToHomeUseCase @Inject constructor(
    private val localStorageManager: LocalStorageManager
) : CanRouteToHomeUseCase {

    companion object {
        private const val IS_LOGGED_IN = "is_logged_in"
    }
    override fun invoke(): Boolean {
        return localStorageManager.getBoolean(IS_LOGGED_IN)
    }
}