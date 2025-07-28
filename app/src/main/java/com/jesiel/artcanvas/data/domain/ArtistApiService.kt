import retrofit2.http.GET
import retrofit2.http.Query

data class ArtistsResponse(
    val pagination: Pagination,
    val data: List<Artist>
)

data class Pagination(
    val total: Int,
    val limit: Int,
    val offset: Int,
    val total_pages: Int,
    val current_page: Int,
    val next_url: String?
)

public data class Artist(
    val id: Int,
    val api_model: String,
    val api_link: String,
    val title: String,
    val sort_title: String,
    val alt_titles: List<String>?,  // pode ser null
    val is_artist: Boolean,
    val birth_date: Int?,
    val death_date: Int?,
    val description: String?,
    val ulan_id: String?,
    val source_updated_at: String?,
    val updated_at: String?,
    val timestamp: String?
)

interface ArticApi {
    @GET("artists")
    suspend fun getArtists(
        @Query("page") page: Int = 1
    ): ArtistsResponse
}
