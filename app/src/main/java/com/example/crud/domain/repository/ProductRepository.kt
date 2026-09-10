package com.example.crud.domain.repository

import com.example.crud.domain.model.ProductModel

interface ProductRepository {
    suspend fun GetAllProducts(): List<ProductModel>

    suspend fun GetProductById(
        id: Int
    ): ProductModel

    suspend fun AddProduct(
        product: ProductModel
    ): ProductModel

    suspend fun UpdateProductById(
        id: Int,
        product: ProductModel
    ): ProductModel

    suspend fun DeleteProductById(
        id: Int
    ): ProductModel
}