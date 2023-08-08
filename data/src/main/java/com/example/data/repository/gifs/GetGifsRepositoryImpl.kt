package com.example.data.repository.gifs

import com.example.common.GetResult
import com.example.common.networkResult
import com.example.domain.usecase.gifs.GetGifsRepository
import com.example.domain.usecase.gifs.Gifs
import com.example.remote.service.GetGifsService
import kotlinx.coroutines.flow.Flow

class GetGifsRepositoryImpl(
    private val service: GetGifsService
) : GetGifsRepository {
    override fun getAllGifs(): Flow<GetResult<List<Gifs>>> =
        networkResult(
            { service.getAllGifs() },
            { remoteData ->
                remoteData.items.map {
                    it.toDomain()
                }
            }
        )
}