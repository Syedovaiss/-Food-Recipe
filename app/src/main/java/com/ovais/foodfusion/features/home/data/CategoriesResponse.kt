package com.ovais.foodfusion.features.home.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesResponse(
    @SerialName("categories")
    val categories: List<Category>? = emptyList()
)

@Serializable
data class Category(
    @SerialName("idCategory")
    val id: String? = null,
    @SerialName("strCategory")
    val category: String? = null,
    @SerialName("strCategoryDescription")
    val description: String? = null,
    @SerialName("strCategoryThumb")
    val image: String? = null
)

sealed interface CategoriesResult {
    data class Success(val data: List<Category>) : CategoriesResult
    data class Failure(val errorMessage: String) : CategoriesResult
}