package com.example.crud.data.remote.api

import com.example.crud.data.remote.dto.req.product.UpdateProductRequest
import com.example.crud.data.remote.dto.req.product.product
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductApiService {
    @GET("products/{id}")
    suspend fun GetProductById(
        @Path("id") id: Int
    ) : product

    @PUT("products/{id}")
    suspend fun UpdateProductById(
        @Path("id") id: Int,
        @Body request: UpdateProductRequest
    ) : product
}