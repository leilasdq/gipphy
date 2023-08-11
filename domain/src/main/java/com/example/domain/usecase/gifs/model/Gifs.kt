package com.example.domain.usecase.gifs.model

data class Gifs(
    val id: String,
    val title: String,
    val username: String,
    val rating: String,
    val image: GifsImage
)
