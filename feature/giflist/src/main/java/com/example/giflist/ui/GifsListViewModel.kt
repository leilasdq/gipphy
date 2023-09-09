package com.example.giflist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.domain.usecase.gifs.GetAllGifsUseCase
import com.example.giflist.ui.contract.AllGifsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class GifsListViewModel(
    private val getAllGifsUseCase: GetAllGifsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AllGifsUiState())
    val uiState: StateFlow<AllGifsUiState> = _uiState

    init {
        getAllGifs()
    }

    private fun getAllGifs() {
        _uiState.update {
            it.copy(
                gifsList = getAllGifsUseCase().cachedIn(viewModelScope),
            )
        }
    }
}