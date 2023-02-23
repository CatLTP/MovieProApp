package com.udemy.movieproapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.udemy.movieproapp.R
import com.udemy.movieproapp.databinding.ActivityMovieBinding
import com.udemy.movieproapp.model.Movie

class MovieActivity : AppCompatActivity() {

    private lateinit var movie : Movie
    private lateinit var activityMovieBinding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        activityMovieBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        val i = intent

        if (i.hasExtra("movie")) {
            movie = intent.getParcelableExtra("movie")!!
            activityMovieBinding.movie = movie
            title = movie.title
        }
    }
}