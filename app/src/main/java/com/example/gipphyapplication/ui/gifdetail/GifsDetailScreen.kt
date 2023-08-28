package com.example.gipphyapplication.ui.gifdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.usecase.gifs.model.Gifs
import com.example.gipphyapplication.ui.gifdetail.contract.GifDetailUiState
import com.example.gipphyapplication.ui.utils.ui.GiffyLoadingState
import com.example.gipphyapplication.ui.utils.ui.GiffyTopAppBar
import com.example.gipphyapplication.ui.utils.ui.components.GifImage
import com.example.gipphyapplication.ui.utils.ui.theme.GiffyTheme

@Composable
fun GifsDetailScreen(
    viewModel: GifsDetailViewModel,
    onNavigateBack: () -> Unit
) {
    GifDetailScreenExtraction(
        viewModel, onNavigateBack
    )
}

@Composable
private fun GifDetailScreenExtraction(
    viewModel: GifsDetailViewModel,
    onNavigateBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    GiffyTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { padding ->
            Column(
                modifier = Modifier.padding(padding),
            ) {
                GiffyTopAppBar(
                    isMainScreen = false,
                    onNavigateBack = onNavigateBack
                )
                GifsScreenContainer(uiState = uiState)
            }
        }
    }

}

@Composable
private fun GifsScreenContainer(
    uiState: GifDetailUiState
) {
    GifDetailItemContainer(
        gifItem = uiState.gifsDetailItem,
        isLoading = uiState.isLoading,
        isError = uiState.isError
    )
}

@Composable
private fun GifDetailItemContainer(
    gifItem: Gifs? = null,
    isLoading: Boolean = false,
    isError: Boolean = false
) {
    if (isLoading) {
        GiffyLoadingState()
    } else if (isError) {
        // TODO -> Impl Error
    } else {
        GifDetailItem(
            gifItem
        )
    }
}

@Composable
private fun GifDetailItem(
    gifItem: Gifs? = null
) {
    gifItem?.let { gif ->
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            verticalArrangement = Arrangement.Top
        ) {
            GifImage(
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(4.dp),
                gifImage = gif.image.original.url
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = gif.title)
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "rating: ")
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = gif.rating)
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "userName: ")
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = gif.username)
            }

        }
    }
}
