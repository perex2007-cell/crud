package com.example.crud.ui.features.product

import com.example.crud.domain.model.ProductModel

data class ProductUIState(
    val isLoading: Boolean = false,
    val product: ProductModel? = null,
    val errorMessage: String? = null
)
