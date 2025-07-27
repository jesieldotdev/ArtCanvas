import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ArtistCardRow(artist: Artist) {
    val padding = 16.dp
    val gap = 8.dp
    val imageSize = 64.dp
    val cornerRadius = 8.dp
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = padding, vertical = padding / 2),
        horizontalArrangement = Arrangement.spacedBy(gap)
    ) {
        AsyncImage(
            model = artist.image,
            contentDescription = artist.name,
            modifier = Modifier
                .size(imageSize)
                .clip(RoundedCornerShape(cornerRadius)),
            contentScale = ContentScale.Crop,
        )
        Column {
            Text(
                artist.name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                artist.lastSeenOnline,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    }
}


