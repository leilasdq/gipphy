package com.example.domain.usecase.gifs

class GetAllGifsUseCase(
    private val repository: GetGifsRepository
) {
    suspend operator fun invoke() = repository.getAllGifs()
}