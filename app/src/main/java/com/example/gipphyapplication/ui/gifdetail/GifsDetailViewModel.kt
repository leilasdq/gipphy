package com.example.gipphyapplication.ui.gifdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.GetResult
import com.example.domain.usecase.gifs.GetAllGifsUseCase
import com.example.domain.usecase.gifs.GetGifDetailsUseCase
import com.example.gipphyapplication.ui.gifdetail.contract.GifDetailUiState
import com.example.gipphyapplication.ui.gifsList.contract.AllGifsUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GifsDetailViewModel(
//    savedStateHandle: SavedStateHandle,
    private val getGifDetailsUseCase: GetGifDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(GifDetailUiState())
    val uiState: StateFlow<GifDetailUiState> = _uiState

    fun getGifDetailObject(gifId: String) {
        viewModelScope.launch {
            getGifDetailsUseCase(GetGifDetailsUseCase.GifDetailUseCaseArgs(gifId = gifId)).collect { result ->
                when (result) {
                    is GetResult.Success -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                gifsDetailItem = result.data
                            )
                        }
                    }
                    is GetResult.Loading -> {
                        _uiState.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                    }
                    is GetResult.Error -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                isError = true
                            )
                        }
                    }
                }
            }
        }
    }
}