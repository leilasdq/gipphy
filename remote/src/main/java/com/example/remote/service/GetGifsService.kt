package com.example.remote.service

import com.example.remote.dto.GifsDto
import com.example.remote.utils.GiffyResponseWrapper

interface GetGifsService {

    suspend fun getAllGifs() : GiffyResponseWrapper<List<GifsDto>>
    suspend fun getGifDetail(id: String): GifsDto
}