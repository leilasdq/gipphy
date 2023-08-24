package com.example.domain.usecase.gifs

import androidx.paging.PagingData
import com.example.domain.usecase.gifs.model.Gifs
import kotlinx.coroutines.flow.Flow

class GetAllGifsUseCase(
    private val repository: GetGifsRepository
) {
    suspend operator fun invoke() = repository.getAllGifs()
}