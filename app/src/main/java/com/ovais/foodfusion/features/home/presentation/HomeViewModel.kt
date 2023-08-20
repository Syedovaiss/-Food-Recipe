package com.ovais.foodfusion.features.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ovais.foodfusion.features.home.domain.CategoriesUseCase
import com.ovais.foodfusion.managers.ToastManager
import com.ovais.foodfusion.utils.transformState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val categoryMapper: CategoryMapper,
    private val categoriesUseCase: CategoriesUseCase,
    private val toastManager: ToastManager
) : ViewModel() {

    private val _categoriesUiData by lazy {
        MutableStateFlow<List<CategoriesUiData>>(listOf())
    }
    val categoriesUiData: StateFlow<List<CategoriesUiData>>
        get() = _categoriesUiData

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        transformState(
            invocation = { categoriesUseCase() },
            onCompleted = { categories ->
                _categoriesUiData.value = categoryMapper.map(categories).take(3)
            },
            onFailed = ::onError
        )
    }

    private fun onError(message: String) {
        toastManager.show(message)
    }

    fun onSearchRecipe(query: String) {
        Log.i("data---", query)
    }

    fun onCategoryClick(category: CategoriesUiData) {

    }
}