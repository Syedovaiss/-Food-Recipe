package com.ovais.foodfusion.features.home.presentation

import com.ovais.foodfusion.common.ui.Mapper
import com.ovais.foodfusion.features.home.data.Category
import com.ovais.foodfusion.utils.default
import javax.inject.Inject

class CategoryMapper @Inject constructor() : Mapper<List<Category>, List<CategoriesUiData>> {

    override fun map(param: List<Category>): List<CategoriesUiData> {
        return param.map { item ->
            CategoriesUiData(
                title = item.category.default(),
                thumbnail = item.image.default()
            )
        }
    }
}