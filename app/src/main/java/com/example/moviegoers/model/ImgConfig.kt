package com.example.moviegoers.model

import com.google.gson.annotations.SerializedName

data class ImgConfig(

	@field:SerializedName("images")
	val images: Images? = null,

	@field:SerializedName("change_keys")
	val changeKeys: List<String?>? = null
)