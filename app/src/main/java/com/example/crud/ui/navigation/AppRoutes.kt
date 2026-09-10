package com.example.crud.ui.navigation

object AppRoutes {
    const val LIST = "list"
    const val DETAILS = "details/{productId}"
    const val FORM = "form?productId={productId}"

    fun details(id: Int) = "details/$id"
    fun form(id: Int? = null) = if (id == null) "form" else "form?productId=$id"
}
