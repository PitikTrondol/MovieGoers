package com.example.moviegoers.common.di

import com.example.moviegoers.repository.FavoriteRepository
import com.example.moviegoers.repository.MovieRepository
import com.example.moviegoers.ui.mainUI.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<MovieRepository> { FavoriteRepository( ) }

    viewModel { MainViewModel(get()) }
}

