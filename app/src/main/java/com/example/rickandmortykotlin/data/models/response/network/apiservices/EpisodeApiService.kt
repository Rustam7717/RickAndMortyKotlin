package com.example.rickandmortykotlin.data.models.response.network.apiservices

import com.example.rickandmortykotlin.data.models.episode.Episode
import com.example.rickandmortykotlin.data.models.response.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {
    @GET("episode")
    suspend fun fetchEpisodes(
        @Query("page") page: Int
    ): RickAndMortyResponse<Episode>

    @GET("episode")
    suspend fun fetchEpisode(
        @Path("id") id: Int
    ): Episode

}