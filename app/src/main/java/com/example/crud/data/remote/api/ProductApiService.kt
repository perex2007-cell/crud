package com.example.crud.data.remote.api

import com.example.crud.data.remote.dto.req.product.UpdateProductRequest
import com.example.crud.data.remote.dto.req.product.product
import com.example.crud.data.remote.dto.res.ProductListResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductApiService {
    @GET("products")
    suspend fun GetAllProducts() : ProductListResponse

    @GET("products/{id}")
    suspend fun GetProductById(
        @Path("id") id: Int
    ) : product

    @POST("products/add")
    suspend fun AddProduct(
        @Body request: UpdateProductRequest
    ) : product

    @PUT("products/{id}")
    suspend fun UpdateProductById(
        @Path("id") id: Int,
        @Body request: UpdateProductRequest
    ) : product

    @DELETE("products/{id}")
    suspend fun DeleteProductById(
        @Path("id") id: Int
    ) : product
}