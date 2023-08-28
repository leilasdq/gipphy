package com.example.common

sealed class GetResult<out T> {
    data class Success<T>(val data: T) : GetResult<T>()
    object Loading : GetResult<Nothing>()
    data class Error<T>(val throwable: Throwable?) : GetResult<T>()
}
