package com.example.crud.ui.features.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crud.domain.model.ProductModel
import com.example.crud.domain.usecase.AddProductUseCase
import com.example.crud.domain.usecase.DeleteProductUseCase
import com.example.crud.domain.usecase.GetAllProductsUseCase
import com.example.crud.domain.usecase.GetProductsUseCase
import com.example.crud.domain.usecase.UpdateProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val addProductUseCase: AddProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProductUIState())
    val uiState: StateFlow<ProductUIState> = _uiState.asStateFlow()

    private val _listUiState = MutableStateFlow(ProductListUIState())
    val listUiState: StateFlow<ProductListUIState> = combine(
        _listUiState,
        _listUiState
    ) { state, _ ->
        val filtered = if (state.searchQuery.isEmpty()) {
            state.products
        } else {
            state.products.filter {
                it.title.contains(state.searchQuery, ignoreCase = true) ||
                        it.id.toString() == state.searchQuery
            }
        }
        state.copy(products = filtered)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ProductListUIState())

    init {
        getAllProducts()
    }

    fun getAllProducts() {
        viewModelScope.launch {
            _listUiState.update { it.copy(isLoading = true, errorMessage = null) }
            try {
                val result = getAllProductsUseCase.Invoke()
                _listUiState.update {
                    it.copy(
                        isLoading = false,
                        products = result,
                        errorMessage = null
                    )
                }
            } catch (e: Exception) {
                _listUiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Error al cargar la lista: ${e.message}"
                    )
                }
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _listUiState.update { it.copy(searchQuery = query) }
    }

    fun getProductById(id: Int) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }
            try {
                val result = getProductsUseCase.Invoke(id)
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        product = result,
                        errorMessage = null
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        product = null,
                        errorMessage = e.message
                    )
                }
            }
        }
    }

    fun updateProduct(id: Int, product: ProductModel) {
        println("DEBUG: updateProduct called for id: $id")
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                updateProductUseCase.Invoke(id, product)
                delay(1000) // Simular tiempo de procesamiento
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = null
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Error al actualizar: ${e.message}"
                    )
                }
            }
        }
    }

    fun addProduct(product: ProductModel) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            try {
                addProductUseCase.Invoke(product)
                delay(1000) // Simular tiempo de procesamiento
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = null
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Error al crear: ${e.message}"
                    )
                }
            }
        }
    }

    fun deleteProduct(id: Int) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            try {
                deleteProductUseCase.Invoke(id)
                delay(1000) // Simular tiempo de procesamiento
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Acción de eliminación simulada"
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Error al eliminar: ${e.message}"
                    )
                }
            }
        }
    }
}
