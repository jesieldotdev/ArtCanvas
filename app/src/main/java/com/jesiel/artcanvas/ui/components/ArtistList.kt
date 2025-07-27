package com.jesiel.artcanvas.ui.components

import ArtistCardRow
import Artists
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ArtistList (artists: Artists){
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