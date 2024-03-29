package com.example.moviegoers.model

import com.google.gson.annotations.SerializedName

data class Genre(

	@field:SerializedName("genres")
	val genres: List<GenresItem?>? = null
)