package com.example.crud.domain.usecase

import com.example.crud.domain.model.ProductModel
import com.example.crud.domain.repository.ProductRepository
import javax.inject.Inject

class UpdateProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend fun Invoke(
        id: Int,
        product: ProductModel
    ): ProductModel {
        return repository.UpdateProductById(id, product)
    }
}