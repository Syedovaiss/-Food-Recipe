package com.ovais.foodfusion.common.navigation

import com.ovais.foodfusion.managers.LocalStorageManager
import javax.inject.Inject

interface NavigationDataProvider {
    val isFirstUse: Boolean
}

class DefaultNavigationDataProvider @Inject constructor(
    private val localStorageManager: LocalStorageManager
) : NavigationDataProvider {
    companion object {
        private const val CAN_MOVE_TO_HOME = "can_move_to_home"
    }

    override val isFirstUse: Boolean
        get() = if (localStorageManager.getBoolean(CAN_MOVE_TO_HOME)) {
            false
        } else {
            localStorageManager.putBoolean(CAN_MOVE_TO_HOME, true)
            true
        }
}