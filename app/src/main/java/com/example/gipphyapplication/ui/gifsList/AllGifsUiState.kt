package com.example.gipphyapplication.ui.gifsList

import com.example.domain.usecase.gifs.model.Gifs

data class AllGifsUiState (
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMsg: String? = null,
    val gifsList: List<Gifs> = emptyList()
)