package com.example.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class GifsDto(
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String,
    @SerialName("username")
    val username: String,
    @SerialName("rating")
    val rating: String,
    @SerialName("images")
    val images: GifImageDto
)