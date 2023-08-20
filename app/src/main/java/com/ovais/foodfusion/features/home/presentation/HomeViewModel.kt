package com.ovais.foodfusion.features.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    fun onSearchRecipe(query: String) {
        Log.i("data---", query)
    }
}