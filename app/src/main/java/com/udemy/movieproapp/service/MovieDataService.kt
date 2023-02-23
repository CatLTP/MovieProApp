package com.udemy.movieproapp.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDataService {

    // End point URL
    // BASE URL : https://api.themoviedb.org/3/
    // API KEY : 62bc16215f48f9346d8c8051cd8627e2
    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey : String) : Call<com.udemy.movieproapp.model.Result>

}