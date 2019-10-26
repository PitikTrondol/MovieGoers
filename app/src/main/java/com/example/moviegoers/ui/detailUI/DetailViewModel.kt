package com.example.moviegoers.ui.detailUI

import androidx.lifecycle.ViewModel
import com.example.moviegoers.model.Genre
import com.example.moviegoers.repository.DetailRepository

class DetailViewModel(private val repo : DetailRepository) : ViewModel() {
    fun getGenres(pop : (Genre) -> Unit) {

        repo.fetchGenres { result ->
            pop(result)
        }
    }
}