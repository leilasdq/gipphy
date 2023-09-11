package com.example.widgets.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.widgets.R
import com.example.widgets.ui.components.GradiantBox

@Composable
fun GiffyTopAppBar(
    isMainScreen: Boolean = false,
    onNavigateBack: () -> Unit = { Unit },
) {
    Column() {
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
    }
}