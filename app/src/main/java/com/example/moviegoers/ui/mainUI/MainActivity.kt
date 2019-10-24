package com.example.moviegoers.ui.mainUI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviegoers.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val mainVM : MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Movie Goers"
        centerText.text = mainVM.showMovies()


    }
}
