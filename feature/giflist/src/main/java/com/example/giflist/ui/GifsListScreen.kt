package com.example.giflist.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.example.domain.usecase.gifs.model.Gifs
import com.example.widgets.R
import com.example.giflist.ui.contract.AllGifsUiState
import com.example.widgets.ui.GiffyLoadingState
import com.example.widgets.ui.GiffyTopAppBar
import com.example.widgets.ui.theme.GiffyTheme

@Composable
fun GifsListScreen(
    viewModel: GifsListViewModel,
    onNavigateToDetailScreen: (String) -> Unit
) {
    GifsScreenExtraction(
        viewModel, onNavigateToDetailScreen
    )
}

@Composable
private fun GifsScreenExtraction(
    viewModel: GifsListViewModel,
    onNavigateToDetailScreen: (String) -> Unit
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
                    isMainScreen = true,
                )
                GifsScreenContainer(
                    uiState = uiState,
                    onNavigateToDetailScreen = onNavigateToDetailScreen,
                )
            }
        }
    }

}

@Composable
private fun GifsScreenContainer(
    uiState: AllGifsUiState,
    onNavigateToDetailScreen: (String) -> Unit
) {
    val lazyPagingItems = uiState.gifsList?.collectAsLazyPagingItems()
    GifsListContainer(
        lazyPagingItems,
        onNavigateToDetailScreen
    )
}

@Composable
private fun GifsListContainer(
    lazyPagingItems: LazyPagingItems<Gifs>?,
    onNavigateToGifsDetails: (String) -> Unit
) {
    val refreshLoadState = lazyPagingItems?.loadState?.refresh

    if (lazyPagingItems == null || refreshLoadState is LoadState.Loading) {
        GiffyLoadingState()
    } else if (refreshLoadState is LoadState.Error) {
        // TODO -> Impl Error
    } else {
        GifsList(
            gifs = lazyPagingItems,
            onNavigateToGifsDetails = onNavigateToGifsDetails
        )
    }
}

@Composable
private fun GifsList(
    gifs: LazyPagingItems<Gifs>,
    onNavigateToGifsDetails: (String) -> Unit
) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,
        ) {
            items(
                count = gifs.itemCount,
            ) { index ->
                val gif = gifs[index]
                gif?.let {
                    GifListItem(it, onNavigateToGifsDetails)
                }
            }
        }
}

@Composable
private fun GifListItem(
    gif: Gifs,
    onNavigateToGifsDetails: (String) -> Unit
) {
    val painter = rememberAsyncImagePainter(
        gif.image.original.url,
        placeholder = painterResource(id = R.drawable.load),
        error = painterResource(id = R.drawable.error)
    )
    Image(
        painter = painter,
        contentDescription = "gif image sample",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .aspectRatio(1f)
            .padding(4.dp)
            .clickable {
                onNavigateToGifsDetails(gif.id)
            }
    )
}
