package com.example.crud.domain.usecase

import com.example.crud.domain.model.ProductModel
import com.example.crud.domain.repository.ProductRepository
import javax.inject.Inject

class DeleteProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend fun Invoke(id: Int): ProductModel {
        return repository.DeleteProductById(id)
    }
}