package com.example.data.repository.gifs

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.example.common.GetResult
import com.example.common.networkResult
import com.example.data.datasource.GifsPagingDataSource
import com.example.data.datasource.LIMIT
import com.example.domain.usecase.gifs.GetGifsRepository
import com.example.domain.usecase.gifs.model.Gifs
import com.example.remote.service.GetGifsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.Exception

class GetGifsRepositoryImpl(
    private val service: GetGifsService
) : GetGifsRepository {
    override fun getAllGifs() =
        Pager(
            config = PagingConfig(
                pageSize = LIMIT,
            ),
            pagingSourceFactory = {
                GifsPagingDataSource(service)
            }
        ).flow.map { it.map { data -> data.toDomain() } }

    override fun getGifDetail(gifId: String): Flow<GetResult<Gifs?>> = networkResult(
        { service.getGifDetail(gifId).items },
        { remoteData ->
            if (remoteData.isNotEmpty()) {
                remoteData[0].toDomain()
            } else {
                throw Exception("No Item found")
            }
        }
    )
}