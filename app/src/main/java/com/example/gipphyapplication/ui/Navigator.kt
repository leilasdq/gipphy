package com.example.gipphyapplication.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gipphyapplication.ui.gifsList.GifsListScreen
import com.example.gipphyapplication.ui.gifsList.GifsListViewModel
import org.koin.androidx.compose.get

@Composable
fun Navigator(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "gifsList") {
        composable("gifsList") {
            val viewModel: GifsListViewModel = get()
            GifsListScreen(
                viewModel = viewModel,
                onNavigateToDetailScreen = {
                    // todo -> Impl to navigate to details
                }
            )
        }
    }
}