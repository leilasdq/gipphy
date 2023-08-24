package com.example.gipphyapplication.ui.gifsList

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.GetResult
import com.example.domain.usecase.gifs.GetAllGifsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GifsListViewModel(
//    savedStateHandle: SavedStateHandle,
    private val getAllGifsUseCase: GetAllGifsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AllGifsUiState())
    val uiState: StateFlow<AllGifsUiState> = _uiState

    init {
        getAllGifs()
    }

    fun updateLoading(isLoading: Boolean) {
        _uiState.update {
            it.copy(
                isLoading = isLoading
            )
        }
    }


    private fun getAllGifs() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                it.copy(
                    gifsList = getAllGifsUseCase(),
                )
            }
        }

    }
}