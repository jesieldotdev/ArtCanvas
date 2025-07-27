package com.jesiel.artcanvas

import ArtistCardRow
import NiceSearchBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import artists
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

                        if (artists.isEmpty()) {
                            Text(
                                text = "No artists match your filter.",

                                modifier = Modifier
                                    .padding(16.dp),
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )


                        } else {
                            LazyColumn(
                                modifier = Modifier.fillMaxSize(),
                            ) {
                                items(artists, key = { artist -> artist.name }) { artistData ->
                                    ArtistCardRow(artist = artistData)
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}
