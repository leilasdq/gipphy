package com.example.data.repository.gifs

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.common.pagingNetworkResult
import com.example.data.datasource.GifsPagingDataSource
import com.example.data.datasource.LIMIT
import com.example.domain.usecase.gifs.GetGifsRepository
import com.example.domain.usecase.gifs.model.Gifs
import com.example.remote.service.GetGifsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

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
}