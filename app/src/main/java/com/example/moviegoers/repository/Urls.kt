package com.example.moviegoers.repository

object Urls {

    const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"
    private const val BASE_URL = "https://api.themoviedb.org/3"
    private const val API_KEY = "747c6d92096c6e53d103232908e38406"

    fun getPopularMovies() : String {
        return "$BASE_URL/movie/popular?api_key=$API_KEY"
    }

    fun getConfiguration() : String {
        return "$BASE_URL/configuration?api_key=$API_KEY"
    }

    fun getMovieGenres() : String {
        return "$BASE_URL/genre/movie/list?api_key=$API_KEY"
    }
}