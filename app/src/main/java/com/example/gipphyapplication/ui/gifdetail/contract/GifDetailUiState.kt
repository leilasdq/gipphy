package com.example.gipphyapplication.ui.gifdetail.contract

import androidx.paging.PagingData
import com.example.domain.usecase.gifs.model.Gifs
import kotlinx.coroutines.flow.Flow

data class GifDetailUiState (
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMsg: String? = null,
    val gifsDetailItem: Gifs? = null
)