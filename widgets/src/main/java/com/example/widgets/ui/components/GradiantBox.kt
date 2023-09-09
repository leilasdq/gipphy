package com.example.widgets.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GradiantBox() {
    Box(
        modifier = Modifier
            .height(4.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFFF5B5B),
                        Color(0xFFFFF152),
                        Color(0xFF09FB8D),
                        Color(0xFF00C5FD),
                        Color(0xFF8D2EFC),
                    )
                )
            )
    )
}