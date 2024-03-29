package com.example.moviegoers.repository

import android.util.Log
import com.example.moviegoers.model.Popular
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import java.io.Reader

class FavoriteRepository {
    fun fetchMovies(responseHandler: (Popular) -> Unit) {
        val httpAsync = Urls.getPopularMovies()
            .httpGet()
            .responseObject(DesPopular()) { _, _, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                    }
                    is Result.Success -> {
                        val data = result.get()
                        responseHandler(data)
                    }
                }
            }

        httpAsync.join()
    }


    class DesPopular : ResponseDeserializable<Popular> {
        override fun deserialize(reader: Reader): Popular? = Gson().fromJson(reader, Popular::class.java)
    }
}