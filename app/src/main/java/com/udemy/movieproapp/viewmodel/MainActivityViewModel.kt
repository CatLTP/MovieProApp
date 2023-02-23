package com.udemy.movieproapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.udemy.movieproapp.model.Movie
import com.udemy.movieproapp.model.MovieRepository

class MainActivityViewModel(application: Application)
    : AndroidViewModel(application) {

        private var movieRepository: MovieRepository
        init {
            movieRepository = MovieRepository(application)
        }

        fun getAllMovies() : LiveData<List<Movie>> {
            return movieRepository.mutableLiveData
        }
}