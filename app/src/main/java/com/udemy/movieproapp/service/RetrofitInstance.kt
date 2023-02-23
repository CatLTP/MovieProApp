package com.udemy.movieproapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var retrofit : Retrofit? = null
    private var BaseURL : String = "https://api.themoviedb.org/3/"

    fun getService() : MovieDataService? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit?.create(MovieDataService::class.java)
    }
}