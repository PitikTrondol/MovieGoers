package com.example.moviegoers.ui.detailUI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.moviegoers.R
import com.example.moviegoers.model.GenresItem
import com.example.moviegoers.model.ResultsItem
import com.example.moviegoers.repository.Urls
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_movie.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        private val INTENT_ARTICLE_ID = "movie_id"
        private val INTENT_ARTICLES = "movie_list"

        fun newIntent(context: Context, movie: List<ResultsItem>, id: Int): Intent {
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra(INTENT_ARTICLE_ID, id)
            intent.putParcelableArrayListExtra(INTENT_ARTICLES, ArrayList(movie))
            return intent
        }
    }

    private val mainVM : DetailViewModel by viewModel()
    private var allGenre : ArrayList<GenresItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        getAllGenres()
    }

    private fun getAllGenres() {
        mainVM.getGenres { result ->
            allGenre.clear()
            for (genre in result.genres!!){
                allGenre.add(genre!!)
            }

            setupDetail()
        }
    }

    private fun getGenre(id : Int) : String {

        for(genre in allGenre) {
            Log.i("AINO", "genreName --- $id "+genre.id)
            if(genre.id == id) {
                return genre.name!!
                break
            }
        }

        return ""
    }

    private fun getGenreNames(genreIds : List<Int?>) : String {

        var name = ""
        for(i in genreIds){
            name+=getGenre(i!!)

            if(i != genreIds.last()) name += ", "
        }
        return name
    }

    private fun setupDetail() {
        val movieList: List<ResultsItem>? = intent.getParcelableArrayListExtra(INTENT_ARTICLES)
        val position: Int = intent.getIntExtra(INTENT_ARTICLE_ID, 0)

        val movie = movieList?.get(position)
        val genre = getGenreNames(movie?.genreIds.orEmpty())
        movie_title.text = movie?.title
        movie_genre.text = genre

        Picasso
            .get()
            .load(Urls.IMAGE_BASE_URL+movie?.posterPath)
            .error(R.drawable.ic_broken_image)
            .placeholder(R.drawable.pb_default_loading_animated)
            .into(detail_image)

        detail_description.text = movie?.overview
        movie_release.text = "Release Date : \n" + movie?.releaseDate
        movie_popularity.text = "Popularity : \n"+movie?.popularity
        movie_vote.text = "Total Votes : \n"+movie?.voteCount
    }

}