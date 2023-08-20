package com.ovais.foodfusion.features.home.domain

import com.ovais.foodfusion.features.home.data.CategoriesResult
import com.ovais.foodfusion.features.home.data.Category
import com.ovais.foodfusion.features.home.data.HomeRepository
import com.ovais.foodfusion.network.State
import com.ovais.foodfusion.network.StateUseCase
import javax.inject.Inject

interface CategoriesUseCase : StateUseCase<List<Category>>

class DefaultCategoriesUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) : CategoriesUseCase {

    override suspend fun invoke(): State<List<Category>> {
        return when (val result = homeRepository.fetchCategories()) {
            is CategoriesResult.Success -> State.Completed(result.data)
            is CategoriesResult.Failure -> State.Failed(result.errorMessage)
        }
    }
}