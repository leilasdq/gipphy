package com.example.domain.usecase.gifs

class GetAllGifsUseCase(
    private val repository: GetGifsRepository
) {
    operator fun invoke() = repository.getAllGifs()
}
