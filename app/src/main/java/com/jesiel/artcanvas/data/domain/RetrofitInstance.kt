import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ArticApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.artic.edu/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ArticApi::class.java)
    }
}
