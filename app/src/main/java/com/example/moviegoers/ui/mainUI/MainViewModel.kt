package com.example.moviegoers.ui.mainUI


import androidx.lifecycle.ViewModel
import com.example.moviegoers.repository.MovieRepository

class MainViewModel(val repo : MovieRepository): ViewModel() {
    fun showMovies()="${repo.getMovieList()} from $this"


}