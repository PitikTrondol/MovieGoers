package com.example.moviegoers.repository

interface MovieRepository {
    fun getMovieList():String
}
class FavoriteRepository : MovieRepository {
    override fun getMovieList(): String {
        return "Test Dependency Injection"
    }
}