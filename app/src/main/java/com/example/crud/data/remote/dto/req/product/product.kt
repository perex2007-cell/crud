package com.example.crud.data.remote.dto.req.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class product(
    @Json(name = "availabilityStatus")
    val availabilityStatus: String? = null,
    @Json(name = "brand")
    val brand: String? = null,
    @Json(name = "category")
    val category: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "dimensions")
    val dimensions: Dimensions? = null,
    @Json(name = "discountPercentage")
    val discountPercentage: Double? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "images")
    val images: List<String>? = null,
    @Json(name = "meta")
    val meta: Meta? = null,
    @Json(name = "minimumOrderQuantity")
    val minimumOrderQuantity: Int? = null,
    @Json(name = "price")
    val price: Double? = null,
    @Json(name = "rating")
    val rating: Double? = null,
    @Json(name = "returnPolicy")
    val returnPolicy: String? = null,
    @Json(name = "reviews")
    val reviews: List<Review>? = null,
    @Json(name = "shippingInformation")
    val shippingInformation: String? = null,
    @Json(name = "sku")
    val sku: String? = null,
    @Json(name = "stock")
    val stock: Int? = null,
    @Json(name = "tags")
    val tags: List<String>? = null,
    @Json(name = "thumbnail")
    val thumbnail: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "warrantyInformation")
    val warrantyInformation: String? = null,
    @Json(name = "weight")
    val weight: Int? = null
)