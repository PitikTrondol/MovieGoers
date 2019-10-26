package com.example.moviegoers.ui.detailUI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.moviegoers.R
import com.example.moviegoers.model.ResultsItem

class DetailMovie : AppCompatActivity() {

    companion object {
        private val INTENT_ARTICLE_ID = "movie_id"
        private val INTENT_ARTICLES = "movie_list"

        fun newIntent(context: Context, movie: List<ResultsItem>, id: Int): Intent {
            val intent = Intent(context, DetailMovie::class.java)
            intent.putExtra(INTENT_ARTICLE_ID, id)
            intent.putParcelableArrayListExtra(INTENT_ARTICLES, ArrayList(movie))
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val articles: List<ResultsItem>? = intent.getParcelableArrayListExtra(INTENT_ARTICLES)
        val position: Int = intent.getIntExtra(INTENT_ARTICLE_ID, 0)

        val movie = articles?.get(position)

        Log.i("AINO", ""+movie?.title)
        Log.i("AINO", ""+movie?.posterPath)
        Log.i("AINO", ""+movie?.originalLanguage)
        Log.i("AINO", ""+movie?.originalTitle)
    }

}