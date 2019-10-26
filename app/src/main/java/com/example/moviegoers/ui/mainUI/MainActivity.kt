package com.example.moviegoers.ui.mainUI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviegoers.R
import com.example.moviegoers.model.ResultsItem
import com.example.moviegoers.ui.detailUI.DetailMovie
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    val mainVM : MainViewModel by viewModel()
    private lateinit var itemAdapter : RvAdapterMovieList
    private var items : ArrayList<ResultsItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Movie Goers"
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<View>(R.id.list) as RecyclerView
        recyclerView.setHasFixedSize(true)

        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        itemAdapter = RvAdapterMovieList(this, object:RvAdapterMovieList.OnItemClickListener{
            override fun onItemClick(item: Int) {
                val intent = DetailMovie.newIntent(this@MainActivity, itemAdapter.data, item)
//                val intent = Intent(this@MainActivity, DetailMovie::class.java)
                startActivity(intent)
            }
        })

        mainVM.getMovies { pop ->
            itemAdapter.data.clear()
            for(movie in pop.results!!)
            {
                itemAdapter.data.add(movie!!)
            }
        }


        recyclerView.adapter = itemAdapter
    }
}
