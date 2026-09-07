package com.example.crud.data.remote.dto.req.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Dimensions(
    @Json(name = "depth")
    val depth: Double,
    @Json(name = "height")
    val height: Double,
    @Json(name = "width")
    val width: Double
)