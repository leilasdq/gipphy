package com.example.gipphyapplication.ui.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gipphyapplication.ui.gifdetail.GifsDetailScreen
import com.example.gipphyapplication.ui.gifdetail.GifsDetailViewModel
import com.example.gipphyapplication.ui.gifsList.GifsListScreen
import com.example.gipphyapplication.ui.gifsList.GifsListViewModel
import org.koin.androidx.compose.get

@Composable
fun Navigator(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screens.GIFS_LIST.route) {
        composable(Screens.GIFS_LIST.route) {
            val viewModel: GifsListViewModel = get()
            GifsListScreen(
                viewModel = viewModel,
                onNavigateToDetailScreen = {
                    navController.navigate(
                        route = Screens.GIFS_DETAIL.route + "/$it"
                    )
                }
            )
        }
        composable(
            route = Screens.GIFS_DETAIL.route + "/{${ScreenArgs.GIFS_ID.argName}}",
            arguments = listOf(navArgument(ScreenArgs.GIFS_ID.argName) {
                type = NavType.StringType
            })
        ) { backStack ->
            val viewModel: GifsDetailViewModel = get()
            GifsDetailScreen(
                viewModel = viewModel,
                gifId = backStack.arguments?.getString(ScreenArgs.GIFS_ID.argName) ?: "",
                onNavigateBack = {
                    navController.navigateUp()
                })
        }
    }
}