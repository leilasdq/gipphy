package com.example.common

sealed class GetResult<out T>(
    val data: T? = null,
    val message: Throwable? = null
) {
    data class Success<T>(val result: T?) : GetResult<T>(result, null)
    data class Loading<T>(val isLoading: Boolean = false) : GetResult<T>()
    data class Error<T>(val result: T? = null, val throwable: Throwable?) : GetResult<T>(result, throwable)
}
