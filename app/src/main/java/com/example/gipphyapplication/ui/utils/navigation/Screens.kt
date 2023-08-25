package com.example.gipphyapplication.ui.utils.navigation

enum class Screens(val route: String) {
    GIFS_LIST("gifsList"),
    GIFS_DETAIL("gifDetail"),
}

enum class ScreenArgs(val argName: String) {
    GIFS_ID("gifId"),
}