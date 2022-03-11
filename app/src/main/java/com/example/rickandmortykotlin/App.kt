package com.example.rickandmortykotlin

import android.app.Application
import com.example.rickandmortykotlin.serviceLocator.networkModule
import com.example.rickandmortykotlin.serviceLocator.repositoriesModel
import com.example.rickandmortykotlin.serviceLocator.viewModelModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(networkModule, repositoriesModel, viewModelModule)
        }
    }
}