package com.example.crud.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.crud.ui.sections.ProductDetails
import com.example.crud.ui.viewmodel.ProductViewModel

@Composable
fun ProductScreen(
    productId: Int,
    viewModel: ProductViewModel = hiltViewModel()
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(productId) {
        viewModel.getProductById(productId)
    }
    ProductDetails(
        uiState = uiState,
        onRetry = { viewModel.getProductById(productId) },
        onUpdate = { updatedProduct ->
            viewModel.updateProduct(productId, updatedProduct)
        }
    )
}