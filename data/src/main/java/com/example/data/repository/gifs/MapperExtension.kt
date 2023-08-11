package com.example.data.repository.gifs

import com.example.domain.usecase.gifs.model.GifImageDetail
import com.example.domain.usecase.gifs.model.Gifs
import com.example.domain.usecase.gifs.model.GifsImage
import com.example.remote.dto.GifImageDetailDto
import com.example.remote.dto.GifImageDto
import com.example.remote.dto.GifsDto

fun GifsDto.toDomain() = Gifs(
    id, title, username, rating, images.toDomain()
)

fun GifImageDto.toDomain() = GifsImage(
    original.toDomain()
)
fun GifImageDetailDto.toDomain() = GifImageDetail(
    url
)

