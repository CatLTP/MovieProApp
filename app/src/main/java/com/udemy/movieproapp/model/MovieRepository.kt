package com.udemy.movieproapp.model

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.udemy.movieproapp.R
import com.udemy.movieproapp.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(
    private var application : Application
) {

    var movies : ArrayList<Movie>? = null
    var mutableLiveData = MutableLiveData<List<Movie>>()
    get() {
        val movieDataService = RetrofitInstance.getService()
        val call = movieDataService?.getPopularMovies(application.applicationContext.getString(R.string.api_key))

        call?.enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                val result = response.body()

                if (result?.results != null) {
                    movies = result.results as ArrayList<Movie>
                    field.value = movies
                }
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return field
     }
}