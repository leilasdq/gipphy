package com.example.gifitemdetail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.GetResult
import com.example.domain.usecase.gifs.GetGifDetailsUseCase
import com.example.gifitemdetail.ui.contract.GifDetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GifsDetailViewModel(
    private val getGifDetailsUseCase: GetGifDetailsUseCase,
    private val gifId: String,
) : ViewModel() {

    private val _uiState = MutableStateFlow(GifDetailUiState())
    val uiState: StateFlow<GifDetailUiState> = _uiState

    init {
        getGifDetailObject(gifId)
    }

    fun retry() {
        getGifDetailObject(gifId)
    }

    private fun getGifDetailObject(gifId: String) {
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