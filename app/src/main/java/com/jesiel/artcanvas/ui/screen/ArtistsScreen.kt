import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jesiel.artcanvas.ui.components.ArtistList
import com.jesiel.artcanvas.ui.theme.ArtCanvasTheme
import kotlinx.coroutines.launch

@Composable
fun ArtistsScreen() {
    val query = remember { mutableStateOf("") }
    var artists by remember { mutableStateOf<List<Artist>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            val response = RetrofitInstance.api.getArtists()
            artists = response.data
        } catch (e: Exception) {
            errorMessage = "Erro ao carregar artistas: ${e.message}"
        } finally {
            isLoading = false
        }
    }

    ArtCanvasTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize().background(Color(0xFFEEEEEE)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when {
                    isLoading -> {
                        CircularProgressIndicator()
                    }
                    errorMessage != null -> {
                        Text(text = errorMessage ?: "")
                    }
                    else -> {
                        Column {
                            NiceSearchBar(
                                query = query.value,
                                onClearQuery = { query.value = "" },
                                onQueryChange = { newValue -> query.value = newValue }
                            )
                            val filteredArtists = artists.filter {
                                it.title.contains(query.value, ignoreCase = true)
                            }
                            ArtistList(
                                filteredArtists,
                                query = query
                            )
                        }
                    }
                }
            }
        }
    }
}
