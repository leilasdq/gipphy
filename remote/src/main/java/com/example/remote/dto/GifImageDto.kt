package com.example.remote.dto

@kotlinx.serialization.Serializable
data class GifImageDto (
    val original: GifImageDetailDto
)

@kotlinx.serialization.Serializable
data class GifImageDetailDto(
    val url: String
)