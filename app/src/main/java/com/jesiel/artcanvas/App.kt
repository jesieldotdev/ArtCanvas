package com.jesiel.artcanvas

import NiceSearchBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import artists
import com.jesiel.artcanvas.ui.components.ArtistList
import com.jesiel.artcanvas.ui.theme.ArtCanvasTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val query = remember { mutableStateOf("") }

            ArtCanvasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {

                        NiceSearchBar(
                            query = query.value,
                            onClearQuery = { query.value = "" },
                            modifier = Modifier.padding(innerPadding)
                        )
                        ArtistList(artists)

                    }
                }
            }
        }
    }
}
