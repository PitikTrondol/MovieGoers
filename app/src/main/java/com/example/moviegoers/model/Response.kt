package com.example.moviegoers.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Response(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<Results?>? = null
)