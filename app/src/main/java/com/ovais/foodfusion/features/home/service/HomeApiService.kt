package com.ovais.foodfusion.features.home.service

import com.ovais.foodfusion.features.home.data.CategoriesResponse
import retrofit2.http.GET

interface HomeApiService {

    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}