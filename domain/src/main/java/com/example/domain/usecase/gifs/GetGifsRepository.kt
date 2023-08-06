package com.example.domain.usecase.gifs

import com.example.common.GetResult
import kotlinx.coroutines.flow.Flow

interface GetGifsRepository {

    fun getAllGifs(): Flow<GetResult<List<Gifs>>>
}