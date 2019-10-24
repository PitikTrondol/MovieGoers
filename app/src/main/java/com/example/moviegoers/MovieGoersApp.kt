package com.example.moviegoers

import android.app.Application
import com.example.moviegoers.common.di.appModule
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
    }
}