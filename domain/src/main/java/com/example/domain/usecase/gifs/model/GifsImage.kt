package com.example.domain.usecase.gifs.model

data class GifsImage (
    val original: GifImageDetail
)

data class GifImageDetail(
    val url: String
)