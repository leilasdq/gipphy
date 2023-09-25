package com.example.domain.usecase.gifs

class GetGifDetailsUseCase(
    private val repository: GetGifsRepository
) {

    data class GifDetailUseCaseArgs(
        val gifId: String
    )

    operator fun invoke(args: GifDetailUseCaseArgs) = with(args) {
        repository.getGifDetail(gifId)
    }
}