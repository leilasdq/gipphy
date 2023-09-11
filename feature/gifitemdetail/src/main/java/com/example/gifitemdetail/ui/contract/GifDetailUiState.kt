package com.example.gifitemdetail.ui.contract

import com.example.domain.usecase.gifs.model.Gifs

data class GifDetailUiState (
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMsg: String? = null,
    val gifsDetailItem: Gifs? = null
)