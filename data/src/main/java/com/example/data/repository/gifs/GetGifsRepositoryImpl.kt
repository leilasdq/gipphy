package com.example.data.repository.gifs

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.example.common.GetResult
import com.example.data.datasource.GifsPagingDataSource
import com.example.data.datasource.LIMIT
import com.example.domain.usecase.gifs.GetGifsRepository
import com.example.remote.service.GetGifsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.lang.Exception

class GetGifsRepositoryImpl(
    private val service: GetGifsService
) : GetGifsRepository {

    override fun getAllGifs() = Pager(
        config = PagingConfig(
            pageSize = LIMIT,
        ),
        pagingSourceFactory = {
            GifsPagingDataSource(service)
        }
    ).flow.map { it.map { data -> data.toDomain() } }

    override fun getGifDetail(gifId: String) = flow {
        emit(GetResult.Loading)
        val response = service.getGifDetail(gifId).items.firstOrNull()
        if (response == null) {
            emit(GetResult.Error(Exception("No data found")))
            return@flow
        }
        emit(GetResult.Success(response.toDomain()))
    }.catch {
        emit(GetResult.Error(it))
    }.flowOn(Dispatchers.IO)
}
