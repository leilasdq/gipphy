package com.example.gipphyapplication.ui.gifsList.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.domain.usecase.gifs.model.Gifs

@Composable
fun AllGigsListScreen(
    gifs: LazyPagingItems<Gifs>
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
                GifListItem(it)
            }
        }
    }
}