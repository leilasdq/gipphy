package com.example.remote.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GiffyResponseWrapper<T : Any>(
    @SerialName("data")
    val items: T
)
