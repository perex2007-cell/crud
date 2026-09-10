package com.example.crud.ui.features.product

import com.example.crud.domain.model.ProductModel

data class ProductListUIState(
    val isLoading: Boolean = false,
    val products: List<ProductModel> = emptyList(),
    val errorMessage: String? = null,
    val searchQuery: String = ""
)
