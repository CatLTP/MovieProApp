package com.udemy.movieproapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.udemy.movieproapp.R
import com.udemy.movieproapp.databinding.MovieListItemBinding
import com.udemy.movieproapp.model.Movie
import com.udemy.movieproapp.view.MovieActivity

class MovieAdapter(
    private var context : Context,
    private var movieArrayList : ArrayList<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(
        val movieListItemBinding: MovieListItemBinding
        ) : RecyclerView.ViewHolder(movieListItemBinding.root) {
        init {
            movieListItemBinding.root.setOnClickListener {
                val position = adapterPosition

                if (position != RecyclerView.NO_POSITION) {
                    val selectedMovie = movieArrayList[position]

                    val i = Intent(context, MovieActivity::class.java)
                    i.putExtra("movie",selectedMovie)
                    context.startActivity(i)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieListItemBinding : MovieListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie_list_item,
            parent,
            false
        )
        return MovieViewHolder(movieListItemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieArrayList[position]
        holder.movieListItemBinding.movie = movie
    }

    override fun getItemCount(): Int {
        return movieArrayList.size
    }


}