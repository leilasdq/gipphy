package com.example.remote.serveceimpl

import com.example.remote.HttpRoutes
import com.example.remote.dto.GifsDto
import com.example.remote.service.GetGifsService
import io.ktor.client.*
import io.ktor.client.request.*

class GetGifsServiceImpl(
    private val client: HttpClient
): GetGifsService {
    override suspend fun getAllGifs(): List<GifsDto> =
        try {
            client.get {
                url {
                    HttpRoutes.ALL_GIFS
                }
            }
        } catch (e: java.lang.Exception) {
            throw e
        }

    override suspend fun getGifDetail(id: String): GifsDto {
        TODO("Not yet implemented")
    }
}