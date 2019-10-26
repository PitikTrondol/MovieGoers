package com.example.moviegoers.ui.mainUI


import androidx.lifecycle.ViewModel
import com.example.moviegoers.model.Popular
import com.example.moviegoers.repository.FavoriteRepository

class MainViewModel(private val repo : FavoriteRepository): ViewModel() {

    fun getMovies(pop : (Popular) -> Unit) {

        repo.fetchMovies { result ->
            pop(result)
        }
    }
}