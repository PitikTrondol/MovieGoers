package com.example.moviegoers.repository

import android.util.Log
import com.example.moviegoers.model.Genre
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import java.io.Reader

class DetailRepository {
    fun fetchGenres(responseHandler: (Genre) -> Unit) {
        val httpAsync = Urls.getMovieGenres()
            .httpGet()
            .responseObject(DesGenre()) { _, _, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("AINO", "DetailRepository Exception --- $ex")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        responseHandler(data)
                        Log.i("AINO", "DetailRepository Success --- ${data.genres?.size}")
                    }
                }
            }

        httpAsync.join()
    }


    class DesGenre : ResponseDeserializable<Genre> {
        override fun deserialize(reader: Reader): Genre? = Gson().fromJson(reader, Genre::class.java)
    }
}