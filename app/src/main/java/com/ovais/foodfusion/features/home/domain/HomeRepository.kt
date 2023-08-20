package com.ovais.foodfusion.features.home.domain

import com.ovais.foodfusion.features.home.data.CategoriesResult
import com.ovais.foodfusion.features.home.data.HomeRepository
import com.ovais.foodfusion.features.home.service.HomeApiService
import com.ovais.foodfusion.network.NetworkDataSource
import com.ovais.foodfusion.network.RepoResult
import com.ovais.foodfusion.utils.default
import javax.inject.Inject

class DefaultHomeRepository @Inject constructor(
    private val apiService: HomeApiService
) : HomeRepository, NetworkDataSource {

    override suspend fun fetchCategories(): CategoriesResult {
        return when (val result = execute { apiService.getCategories() }) {
            is RepoResult.Success -> CategoriesResult.Success(result.data.categories.orEmpty())
            is RepoResult.Failure -> CategoriesResult.Failure(result.error.errorMessage.default())
        }
    }
}