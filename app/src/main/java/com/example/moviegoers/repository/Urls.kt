package com.example.moviegoers.repository

object Urls {
    private const val BASE_URL = "https://api.themoviedb.org/3"
    private const val API_KEY = "747c6d92096c6e53d103232908e38406"

    fun getPopularMovies() : String {
        return "$BASE_URL/movie/popular?api_key=$API_KEY"
    }

    fun getTopRatedMovies() : String {
        return "$BASE_URL/movie/top_rated?api_key=$API_KEY"
    }
}