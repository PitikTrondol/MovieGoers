package com.example.moviegoers.common.di

import com.example.moviegoers.repository.DetailRepository
import com.example.moviegoers.repository.FavoriteRepository
import com.example.moviegoers.ui.detailUI.DetailViewModel
import com.example.moviegoers.ui.mainUI.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single{ FavoriteRepository() }
    single{ DetailRepository() }

    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}

