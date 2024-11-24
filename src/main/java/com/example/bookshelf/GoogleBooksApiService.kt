package com.example.bookshelf

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// API Service Interface
interface GoogleBooksApiService {
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): BookResponse
}

// Retrofit Instance
object RetrofitInstance {
    private const val BASE_URL = "https://www.googleapis.com/books/v1/"

    val api: GoogleBooksApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GoogleBooksApiService::class.java)
    }
}
