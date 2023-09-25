package com.example.widgets.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.widgets.ui.components.LoadingAnimation

@Composable
fun GiffyLoadingState() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .testTag("loadingState"),
        contentAlignment = Alignment.Center
    ) {
        LoadingAnimation()
    }
}