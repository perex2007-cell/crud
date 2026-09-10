package com.example.crud.domain.usecase

import com.example.crud.domain.model.ProductModel
import com.example.crud.domain.repository.ProductRepository
import javax.inject.Inject

class AddProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend fun Invoke(product: ProductModel): ProductModel {
        return repository.AddProduct(product)
    }
}