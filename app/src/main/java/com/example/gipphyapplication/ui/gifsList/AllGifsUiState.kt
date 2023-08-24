package com.example.gipphyapplication.ui.gifsList

import androidx.paging.PagingData
import com.example.domain.usecase.gifs.model.Gifs
import kotlinx.coroutines.flow.Flow

data class AllGifsUiState (
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMsg: String? = null,
    val gifsList: Flow<PagingData<Gifs>>? = null
)