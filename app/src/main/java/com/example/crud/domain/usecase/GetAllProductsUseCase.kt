package com.example.crud.domain.usecase

import com.example.crud.domain.model.ProductModel
import com.example.crud.domain.repository.ProductRepository
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend fun Invoke(): List<ProductModel> {
        return repository.GetAllProducts()
    }
}