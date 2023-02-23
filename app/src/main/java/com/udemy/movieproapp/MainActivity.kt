package com.udemy.movieproapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.udemy.movieproapp.adapter.MovieAdapter
import com.udemy.movieproapp.databinding.ActivityMainBinding
import com.udemy.movieproapp.model.Movie
import com.udemy.movieproapp.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var movies : ArrayList<Movie>
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var mainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Movie Pro App"
        mainActivityBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        getPopularMovies()

        swipeRefreshLayout = mainActivityBinding.swipeLayout
        swipeRefreshLayout.setColorSchemeResources(R.color.teal_200)
        swipeRefreshLayout.setOnRefreshListener {
            getPopularMovies()
        }

    }

    private fun getPopularMovies() {
        mainActivityViewModel.getAllMovies().observe(this) { moviesLiveData ->
            movies = moviesLiveData as ArrayList<Movie>
            showOnRecyclerView()

        }
    }

    private fun showOnRecyclerView() {
        recyclerView = mainActivityBinding.rvMovies
        movieAdapter = MovieAdapter(this,movies)

        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.layoutManager = GridLayoutManager(this,2)
        }
        else {
            recyclerView.layoutManager = GridLayoutManager(this,4)
        }

        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = movieAdapter
        movieAdapter.notifyDataSetChanged()
    }
}