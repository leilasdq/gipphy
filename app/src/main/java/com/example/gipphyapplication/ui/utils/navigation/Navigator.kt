package com.example.gipphyapplication.ui.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gifitemdetail.ui.GifsDetailScreen
import com.example.gifitemdetail.ui.GifsDetailViewModel
import com.example.giflist.ui.GifsListScreen
import com.example.giflist.ui.GifsListViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

@Composable
fun Navigator(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screens.GIFS_LIST.route) {
        composable(Screens.GIFS_LIST.route) {
            val viewModel: GifsListViewModel = koinViewModel()
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
            val viewModel: GifsDetailViewModel = koinInject {
                parametersOf(backStack.arguments?.getString(ScreenArgs.GIFS_ID.argName) ?: "")
            }
            GifsDetailScreen(
                viewModel = viewModel,
                onNavigateBack = {
                    navController.navigateUp()
                })
        }
    }
}