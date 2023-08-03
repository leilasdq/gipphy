package com.example.remote.service

import com.example.remote.dto.GifsDto

interface GetGifsService {

    suspend fun getAllGifs() : List<GifsDto>
    suspend fun getGifDetail(id: String): GifsDto
}