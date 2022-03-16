package com.example.rickandmortykotlin.data.network.apiservices

import com.example.rickandmortykotlin.data.network.models.episode.Episode
import com.example.rickandmortykotlin.data.network.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {
    @GET("episode")
    suspend fun fetchEpisodes(
        @Query("page") page: Int
    ): RickAndMortyResponse<Episode>

    @GET("episode")
    suspend fun fetchEpisodeId(
        @Path("id") id: Int
    ): Episode

}