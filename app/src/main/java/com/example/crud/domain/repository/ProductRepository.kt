package com.example.crud.domain.repository

import com.example.crud.domain.model.ProductModel

interface ProductRepository {
    suspend fun GetProductById(
        id: Int
    ): ProductModel

    suspend fun UpdateProductById(
        id: Int,
        product: ProductModel
    ): ProductModel
}