package com.example.crud.data.repository

import com.example.crud.data.mapper.toDomain
import com.example.crud.data.mapper.toUpdateDto
import com.example.crud.data.remote.api.ProductApiService
import com.example.crud.domain.model.ProductModel
import com.example.crud.domain.repository.ProductRepository
import javax.inject.Inject


class ProductRepositoryImp @Inject constructor(
    private val api: ProductApiService
): ProductRepository {
    override suspend fun GetProductById(id: Int): ProductModel{
        val response = api.GetProductById(id)
        return response.toDomain()
    }

    override suspend fun UpdateProductById(id: Int, product: ProductModel): ProductModel {
        val request = product.toUpdateDto()
        val response = api.UpdateProductById(id, request)
        return response.toDomain()
    }
}