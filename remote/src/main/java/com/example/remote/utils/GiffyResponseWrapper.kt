package com.example.remote.utils

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class GiffyResponseWrapper<T : Any>(
    @SerialName("data")
    val items: T
)