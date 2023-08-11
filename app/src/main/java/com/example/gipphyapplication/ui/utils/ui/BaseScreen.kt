package com.example.gipphyapplication.ui.utils.ui

import LoadingAnimation
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gipphyapplication.R
import com.example.gipphyapplication.ui.utils.ui.theme.GiffyTheme

@Composable
fun BaseScreen(
    isMainScreen: Boolean = false,
    isLoading: Boolean = false,
    onNavigateBack: () -> Unit = { Unit },
    content: @Composable () -> Unit
) {
    GiffyTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { padding ->
            Column(
                modifier = Modifier.padding(padding),
            ) {
                TopAppBar(
                    backgroundColor = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.giphy_logo),
                        contentDescription = "logo",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .width(120.dp)
                            .padding(horizontal = 4.dp)
                    )
                    Spacer(
                        Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )
                    if (isMainScreen.not()) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "back",
                            modifier = Modifier.clickable {
                                onNavigateBack()
                            },
                            tint = Color.White
                        )
                    }
                }
                GradiantBox()
                if (isLoading) {
                    LoadingAnimation()
                } else {
                    content()
                }
            }

        }
    }

}