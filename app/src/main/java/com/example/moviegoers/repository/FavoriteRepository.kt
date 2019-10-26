package com.example.moviegoers.repository

import android.util.Log
import com.example.moviegoers.model.Popular
import com.example.moviegoers.model.ResultsItem
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result;
import com.google.gson.Gson
import java.io.Reader


class FavoriteRepository {

    fun test(): ArrayList<ResultsItem> {

        var dummy: ArrayList<ResultsItem> = ArrayList()
        for (i in 1..10) {
            var a = ResultsItem()
            dummy.add(a)
        }

        return dummy
    }

    fun fetchMovies(responseHandler: (Popular) -> Unit) {
        val httpAsync = Urls.getPopularMovies()
            .httpGet()
            .responseObject(Deserializer()) { _, _, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("AINO", "Exception --- $ex")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        responseHandler(data)
                        Log.i("AINO", "Success --- ${data.results?.size}")
                    }
                }
            }

        httpAsync.join()
    }


    class Deserializer : ResponseDeserializable<Popular> {
        override fun deserialize(reader: Reader): Popular? = Gson().fromJson(reader, Popular::class.java)
    }
}