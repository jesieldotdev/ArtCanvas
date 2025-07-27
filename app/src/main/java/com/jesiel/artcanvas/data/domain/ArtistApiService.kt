import okhttp3.OkHttpClient
import okhttp3.Request

fun getArtists(): String? {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://api.artic.edu/api/v1/artists")
        .build()

    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) return null
        return response.body?.string()
    }
}
