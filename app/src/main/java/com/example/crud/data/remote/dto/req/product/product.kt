package com.example.crud.data.remote.dto.req.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class product(
    @Json(name = "brand")
    val brand: String? = null,
    @Json(name = "category")
    val category: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "price")
    val price: Double? = null,
    @Json(name = "title")
    val title: String? = null
)