package com.jesiel.artcanvas.ui.components

import Artist
import ArtistCardRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ArtistList (artists: List<Artist>, query: MutableState<String>){
    if (artists.isEmpty()) {
        Text(
            text = "No artists match your filter.",

            modifier = Modifier
                .padding(16.dp),

        )


    } else {
        val filteredArtists = artists.filter {it.title.contains(query.value, ignoreCase = true)}

        LazyColumn(
            modifier = Modifier.fillMaxSize(),

        ) {
            items(filteredArtists, key = { artist-> artist.title}) { artistData ->
                ArtistCardRow(artist = artistData)
            }
        }
    }
}

