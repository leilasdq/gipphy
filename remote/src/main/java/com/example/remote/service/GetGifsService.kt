package com.example.remote.service

import com.example.remote.dto.GifsDto
import com.example.remote.utils.GiffyResponseWrapper

interface GetGifsService {

    suspend fun getAllGifs(limit: Int, offset: Int) : GiffyResponseWrapper<List<GifsDto>>
    suspend fun getGifDetail(id: String): GifsDto
}