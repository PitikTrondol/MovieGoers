package com.example.moviegoers.ui.mainUI


import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.moviegoers.model.Popular
import com.example.moviegoers.model.ResultsItem
import com.example.moviegoers.repository.FavoriteRepository

class MainViewModel(private val repo : FavoriteRepository): ViewModel() {

    fun test() : ArrayList<ResultsItem> = repo.test()
    private val movies : Popular? = null

    fun getMovies() {

        Log.i("AINO", "LALALALA $movies")
    }
}