package com.ovais.foodfusion.managers

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface ToastManager {
    fun show(message: String)
}

class DefaultToastManager @Inject constructor(
    @ApplicationContext private val context: Context
) : ToastManager {
    override fun show(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}