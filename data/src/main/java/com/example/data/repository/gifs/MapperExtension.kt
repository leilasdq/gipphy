package com.example.data.repository.gifs

import com.example.domain.usecase.gifs.Gifs
import com.example.remote.dto.GifsDto

fun GifsDto.toDomain() = Gifs(
    id, title, username, rating
)