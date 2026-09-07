package com.example.crud.ui.state

import com.example.crud.domain.model.ProductModel

data class ProductUIState(
    val isLoading: Boolean = false,
    val product: ProductModel? = null,
    val errorMessage: String? = null
)