package com.example.crud.domain.model

data class ProductModel (
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val brand: String = "",
    val stock: Int = 0,
    val rating: Double = 0.0,
    val discountPercentage: Double = 0.0,
    val thumbnail: String = ""
)
