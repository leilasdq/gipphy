package com.example.widgets.ui.theme

import alistar.sample.githubusers.libraries.design.theme.BackgroundDark
import alistar.sample.githubusers.libraries.design.theme.BackgroundLight
import alistar.sample.githubusers.libraries.design.theme.OnBackgroundDark
import alistar.sample.githubusers.libraries.design.theme.OnBackgroundLight
import alistar.sample.githubusers.libraries.design.theme.PrimaryDark
import alistar.sample.githubusers.libraries.design.theme.PrimaryLight
import alistar.sample.githubusers.libraries.design.theme.Red
import alistar.sample.githubusers.libraries.design.theme.Red40
import alistar.sample.githubusers.libraries.design.theme.SecondaryDark
import alistar.sample.githubusers.libraries.design.theme.SecondaryLight
import alistar.sample.githubusers.libraries.design.theme.Shapes
import alistar.sample.githubusers.libraries.design.theme.SurfaceDark
import alistar.sample.githubusers.libraries.design.theme.SurfaceLight
import alistar.sample.githubusers.libraries.design.theme.Typography
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = PrimaryDark,
    secondary = SecondaryDark,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
    surface = SurfaceDark,
    error = Red40,
    onError = Red
)

private val LightColorPalette = lightColors(
    primary = PrimaryLight,
    secondary = SecondaryLight,
    background = BackgroundLight,
    onBackground = OnBackgroundLight,
    error = Red40,
    onError = Red,
    surface = SurfaceLight,
    onSecondary = OnBackgroundLight
)

@Composable
fun GiffyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
