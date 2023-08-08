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

    init {
        getAllGifs()
    }

    private val _uiState = MutableStateFlow(AllGifsUiState())
    val uiState: StateFlow<AllGifsUiState> = _uiState


    private fun getAllGifs() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllGifsUseCase().collect { result ->
                when (result) {
                    is GetResult.Success -> {
                        _uiState.update {
                            it.copy(
                                gifsList = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                    }

                    is GetResult.Loading -> {
                        _uiState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }

                    is GetResult.Error -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                isError = true,
                                errorMsg = result.throwable?.message
                            )
                        }
                    }
                }
            }
        }

    }
}