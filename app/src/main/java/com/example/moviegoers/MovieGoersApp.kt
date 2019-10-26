package com.example.moviegoers

import android.app.Application
import com.example.moviegoers.common.di.appModule
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieGoersApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieGoersApp)
            androidLogger()
            modules(appModule)
        }

        val builder = Picasso.Builder(this)
        builder.downloader(OkHttp3Downloader(this, (5 * 1024 * 1024).toLong()))
        val built = builder.build()
        built.setIndicatorsEnabled(true)
        built.isLoggingEnabled = true
        Picasso.setSingletonInstance(built)
    }
}