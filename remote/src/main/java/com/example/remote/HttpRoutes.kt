package com.example.remote

object HttpRoutes {

    private const val BASE_URL = "https://api.giphy.com/v1"
    const val ALL_GIFS = "$BASE_URL/gifs/trending"
    const val GIF_DETAIL = "$BASE_URL/gifs"
}