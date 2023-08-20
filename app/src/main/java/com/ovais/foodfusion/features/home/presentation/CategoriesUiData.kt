package com.ovais.foodfusion.features.home.presentation

import kotlinx.serialization.Serializable

@Serializable
data class CategoriesUiData(
    val title: String,
    val thumbnail: String
)