package com.example.remote.serveceimpl

import com.example.remote.BuildConfig
import com.example.remote.HttpRoutes
import com.example.remote.dto.GifsDto
import com.example.remote.service.GetGifsService
import com.example.remote.utils.Constants.API_KEY
import com.example.remote.utils.Constants.GIF_ID
import com.example.remote.utils.Constants.LIMIT
import com.example.remote.utils.Constants.OFFSET
import com.example.remote.utils.GiffyResponseWrapper
import io.ktor.client.*
import io.ktor.client.request.*

class GetGifsServiceImpl(
    private val client: HttpClient
): GetGifsService {
    override suspend fun getAllGifs(limit: Int, offset: Int): GiffyResponseWrapper<List<GifsDto>> =
        try {
            client.get {
                url(HttpRoutes.ALL_GIFS)
                parameter(API_KEY, BuildConfig.API_KEY)
                parameter(LIMIT, limit)
                parameter(OFFSET, offset)
            }
        } catch (e: java.lang.Exception) {
            throw e
        }

    override suspend fun getGifDetail(id: String): GiffyResponseWrapper<List<GifsDto>> =
        try {
            client.get {
                url(HttpRoutes.GIF_DETAIL)
                parameter(API_KEY, BuildConfig.API_KEY)
                parameter(GIF_ID, id)
            }
        } catch (e: java.lang.Exception) {
            throw e
        }
    }