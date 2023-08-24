package com.example.domain.usecase.gifs

import androidx.paging.PagingData
import com.example.common.GetResult
import com.example.domain.usecase.gifs.model.Gifs
import kotlinx.coroutines.flow.Flow

interface GetGifsRepository {

    fun getAllGifs(): Flow<PagingData<Gifs>>
}