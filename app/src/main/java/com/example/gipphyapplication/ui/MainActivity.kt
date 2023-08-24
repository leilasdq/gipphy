package com.example.gipphyapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.gipphyapplication.ui.gifsList.GifsListViewModel
import com.example.gipphyapplication.ui.gifsList.screen.AllGigsListScreen
import com.example.gipphyapplication.ui.utils.ui.BaseScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val viewModel: GifsListViewModel by viewModel()

        super.onCreate(savedInstanceState)
        setContent {

            val state = viewModel.uiState.collectAsState()
            val lazyPagingItems = state.value.gifsList?.collectAsLazyPagingItems()
            val refreshLoadState = lazyPagingItems?.loadState?.refresh

            BaseScreen(
                isMainScreen = true,
                isLoading = state.value.isLoading,
            ) {

                if (refreshLoadState is LoadState.Loading) {
                    viewModel.updateLoading(true)
                } else {
                    if (lazyPagingItems!= null) {
                        viewModel.updateLoading(false)
                        AllGigsListScreen(lazyPagingItems)
                    }
                }

            }

        }
    }
}