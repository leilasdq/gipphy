package com.example.gipphyapplication.ui.gifsList.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.domain.usecase.gifs.model.Gifs
import com.example.gipphyapplication.R

@Composable
fun GifListItem(
    gif: Gifs
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
    )
}