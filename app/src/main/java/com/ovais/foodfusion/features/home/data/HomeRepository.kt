package com.ovais.foodfusion.features.home.data

interface HomeRepository {
    suspend fun fetchCategories(): CategoriesResult
}