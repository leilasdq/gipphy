package com.example.gipphyapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val hello by inject<String>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            Text(hello)
        }
    }
}