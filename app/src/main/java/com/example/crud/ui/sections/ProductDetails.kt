package com.example.crud.ui.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.crud.domain.model.ProductModel
import com.example.crud.ui.components.productCard
import com.example.crud.ui.state.ProductUIState

@Composable
fun ProductDetails(
    uiState: ProductUIState,
    onRetry: () -> Unit,
    onUpdate: (ProductModel) -> Unit
) {
    when {
        uiState.isLoading -> {
            CircularProgressIndicator()
        }
        uiState.errorMessage != null -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = uiState.errorMessage?: "Error en la cargar del producto"
                )
            }
            Button(
                onClick = onRetry
            ) {
                Text(
                    text = "Reintentar"
                )
            }
        }
        uiState.product != null -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                productCard(
                    product = uiState.product
                )
                Button(
                    onClick = {
                        val updatedProduct = uiState.product.copy(
                            title = "Producto Actualizado",
                            description = "Se confirma que se actualizo la informacion del producto."
                        )
                        onUpdate(updatedProduct)
                    }
                ) {
                    Text(text = "Actualizar")
                }
                Button(
                    onClick = onRetry
                ) {
                    Text(text = "Inicio")
                }
            }
        }
    }
}