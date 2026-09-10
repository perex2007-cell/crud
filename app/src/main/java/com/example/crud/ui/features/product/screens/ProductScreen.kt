package com.example.crud.ui.features.product.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.crud.ui.features.product.ProductViewModel

@Composable
fun ProductScreen(
    productId: Int,
    viewModel: ProductViewModel = hiltViewModel(),
    onBack: () -> Unit,
    onEdit: (Int) -> Unit
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    
    LaunchedEffect(productId) {
        viewModel.getProductById(productId)
    }
    
    ProductDetails(
        uiState = uiState,
        onRetry = { viewModel.getProductById(productId) },
        onDelete = { id ->
            viewModel.deleteProduct(id)
            onBack()
        },
        onBack = onBack,
        onEdit = { onEdit(productId) }
    )
}
