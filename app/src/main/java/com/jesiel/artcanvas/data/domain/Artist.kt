data class Artist(
    val name: String,
    val lastSeenOnline: String = "",
    val image: String
)

typealias Artists = List<Artist>