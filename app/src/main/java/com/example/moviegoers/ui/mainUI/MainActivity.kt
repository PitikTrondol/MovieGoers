package com.example.moviegoers.ui.mainUI

import android.content.Intent
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

        setupRecyclerView(mainVM.test())
        mainVM.getMovies()
        Log.i("AINO", "MUMEEEET")
    }

    private fun setupRecyclerView(items : ArrayList<ResultsItem>) {
        val recyclerView = findViewById<View>(R.id.list) as RecyclerView
        recyclerView.setHasFixedSize(true)

        val layoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = layoutManager

        itemAdapter = RvAdapterMovieList(this, object:RvAdapterMovieList.OnItemClickListener{
            override fun onItemClick(item: Int) {
                val intent = Intent(this@MainActivity, DetailMovie::class.java)
                startActivity(intent)
            }
        })

        itemAdapter.data.clear()
        itemAdapter.data.addAll(items)

        recyclerView.adapter = itemAdapter
    }
}
