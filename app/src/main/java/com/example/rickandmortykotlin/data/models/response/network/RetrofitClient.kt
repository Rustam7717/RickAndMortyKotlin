package com.example.rickandmortykotlin.data.models.response.network

import com.example.rickandmortykotlin.data.models.response.network.apiservices.CharacterApiService
import com.example.rickandmortykotlin.data.models.response.network.apiservices.EpisodeApiService
import com.example.rickandmortykotlin.data.models.response.network.apiservices.LocationApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

   private val okHttpClient: OkHttpClient = OkHttpClient()
       .newBuilder()
       .addInterceptor(provideLoggingInterceptor())
       .connectTimeout(30, TimeUnit.SECONDS)
       .readTimeout(30, TimeUnit.SECONDS)
       .writeTimeout(30, TimeUnit.SECONDS)
       .build()

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val provideRetrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCharacterApiService(): CharacterApiService =
        provideRetrofit.create(CharacterApiService::class.java)

    fun provideLocationApiService(): LocationApiService =
        provideRetrofit.create(LocationApiService::class.java)

    fun provideEpisodeApiService(): EpisodeApiService =
        provideRetrofit.create(EpisodeApiService::class.java)


}










