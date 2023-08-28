package com.example.data.repository.gifs

import com.example.domain.usecase.gifs.model.GifImageDetail
import com.example.domain.usecase.gifs.model.Gifs
import com.example.domain.usecase.gifs.model.GifsImage
import com.example.remote.dto.GifImageDetailDto
import com.example.remote.dto.GifImageDto
import com.example.remote.dto.GifsDto

fun GifsDto.toDomain() = Gifs(
    id = id,
    title = title,
    username = username,
    rating = rating,
    image = images.toDomain(),
)

fun GifImageDto.toDomain() = GifsImage(original = original.toDomain())

fun GifImageDetailDto.toDomain() = GifImageDetail(url = url)
