package com.example.gipphyapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gipphyapplication.ui.gifsList.GifsListViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val hello by inject<String>()
    override fun onCreate(savedInstanceState: Bundle?) {

        val viewModel: GifsListViewModel by viewModel()

        super.onCreate(savedInstanceState)
        setContent {

            val state = viewModel.uiState.collectAsState()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                state.value.gifsList.forEach {
                    Text(it.title)
                    Spacer(modifier = Modifier.size(8.dp))
                }
            }
        }
    }
}