package com.example.rickandmortykotlin.di

import com.example.rickandmortykotlin.data.network.RetrofitClient
import com.example.rickandmortykotlin.data.network.apiservices.CharacterApiService
import com.example.rickandmortykotlin.data.network.apiservices.EpisodeApiService
import com.example.rickandmortykotlin.data.network.apiservices.LocationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object NetworkModule {
//
//    @Singleton
//    val retrofitClient = RetrofitClient()
//
//    @Provides
//    @Singleton
//    fun provideCharacterApiService(): CharacterApiService =
//        retrofitClient.provideCharacterApiService()
//
//    @Provides
//    @Singleton
//    fun provideLocationApiService(): LocationApiService =
//        retrofitClient.provideLocationApiService()
//
//    @Provides
//    @Singleton
//    fun provideEpisodeApiService(): EpisodeApiService =
//        retrofitClient.provideEpisodeApiService()
//}
