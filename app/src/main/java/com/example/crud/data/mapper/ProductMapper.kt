package com.example.crud.data.mapper

import com.example.crud.data.remote.dto.req.product.UpdateProductRequest
import com.example.crud.data.remote.dto.req.product.product
import com.example.crud.domain.model.ProductModel

fun product.toDomain(): ProductModel{
    return ProductModel(
        id = id ?: 0,
        title = title ?: "",
        description = description ?: "",
        category = category ?: "",
        price = price ?: 0.0
    )
}

fun ProductModel.toUpdateDto(): UpdateProductRequest {
    return UpdateProductRequest(
        title = title,
        description = description,
        category = category,
        price = price
    )
}