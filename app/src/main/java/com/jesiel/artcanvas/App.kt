package com.jesiel.artcanvas

import ArtistsScreen
import NiceSearchBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val query = remember { mutableStateOf("") }
//            NiceSearchBar(query=query.value, onClearQuery = { query.value = "" })
        ArtistsScreen()
        }
    }
}
