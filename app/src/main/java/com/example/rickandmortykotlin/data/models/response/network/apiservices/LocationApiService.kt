package com.example.rickandmortykotlin.data.models.response.network.apiservices

import com.example.rickandmortykotlin.data.models.location.Location
import com.example.rickandmortykotlin.data.models.response.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApiService {
    @GET("location")
    suspend fun fetchLocations(
        @Query("page") page: Int
    ): RickAndMortyResponse<Location>

    @GET("location")
    suspend fun fetchLocation(
        @Path("id") id: Int
    ): Location

}