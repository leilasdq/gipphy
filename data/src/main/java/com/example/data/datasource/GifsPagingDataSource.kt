package com.example.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.remote.dto.GifsDto
import com.example.remote.service.GetGifsService

const val LIMIT = 15
class GifsPagingDataSource(
    private val gifsService: GetGifsService,
): PagingSource<Int, GifsDto>() {
    override fun getRefreshKey(state: PagingState<Int, GifsDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GifsDto> {
        return try {
            val page = params.key ?: 0
            val response = gifsService.getAllGifs(offset = page * LIMIT, limit = LIMIT)

            LoadResult.Page(
                data = response.items,
                prevKey = if (page == 0) null else page.minus(1),
                nextKey = if (response.items.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}