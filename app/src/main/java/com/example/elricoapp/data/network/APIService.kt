    package com.example.elricoapp.data.network

    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory


    object APIService {
        private fun initRetrofit(): Retrofit {

            return Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/books/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val services: NYTServices = initRetrofit().create(NYTServices::class.java)

    }