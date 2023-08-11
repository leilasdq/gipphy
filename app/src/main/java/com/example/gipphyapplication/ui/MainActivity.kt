package com.example.gipphyapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
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

            BaseScreen(
                isMainScreen = true,
                isLoading = state.value.isLoading,
            ) {
                AllGigsListScreen(state.value.gifsList)
            }

        }
    }
}