    package com.example.elricoapp.data.network

    import com.example.elricoapp.data.response.BookBodyResponse
    import retrofit2.Call
    import retrofit2.http.GET
    import retrofit2.http.Query

    interface NYTServices {
        @GET("lists.json")
        fun getBooks(
            @Query("list") List: String = "hardcover-fiction",
            @Query("api-key") apikey: String = "jokKE3A6jJS3w7cXDnVCBjM3Sc0SqsJA"
        ) : Call<BookBodyResponse>

    }
