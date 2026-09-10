package com.example.crud.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.crud.ui.features.product.ProductViewModel
import com.example.crud.ui.features.product.screens.ProductFormScreen
import com.example.crud.ui.features.product.screens.ProductListScreen
import com.example.crud.ui.features.product.screens.ProductScreen
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun ProductNavHost() {
    val navController = rememberNavController()
    val viewModel: ProductViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = AppRoutes.LIST) {
        composable(AppRoutes.LIST) {
            ProductListScreen(
                viewModel = viewModel,
                onProductClick = { id ->
                    navController.navigate(AppRoutes.details(id))
                },
                onAddProductClick = {
                    navController.navigate(AppRoutes.form())
                }
            )
        }
        
        composable(
            route = AppRoutes.DETAILS,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            ProductScreen(
                productId = productId,
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onEdit = { id ->
                    navController.navigate(AppRoutes.form(id))
                }
            )
        }
        
        composable(
            route = AppRoutes.FORM,
            arguments = listOf(navArgument("productId") { 
                type = NavType.IntType
                defaultValue = -1
            })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: -1
            ProductFormScreen(
                viewModel = viewModel,
                productId = if (productId == -1) null else productId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
