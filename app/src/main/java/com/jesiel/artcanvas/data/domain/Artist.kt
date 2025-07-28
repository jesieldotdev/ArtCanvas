data class ArtistMock(
    val name: String,
    val lastSeenOnline: String = "",
    val image: String
)

typealias ArtistsMock = List<ArtistMock>