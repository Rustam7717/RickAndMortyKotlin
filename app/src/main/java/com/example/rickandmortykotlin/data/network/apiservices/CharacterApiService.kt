package com.example.rickandmortykotlin.data.network.apiservices

import com.example.rickandmortykotlin.data.network.models.character.Character
import com.example.rickandmortykotlin.data.network.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("character/{id}")
   suspend fun fetchCharacter(@Path("id") id: Int): Character

    @GET("character")
   suspend fun fetchCharacters(
        @Query("page") page: Int,
    ): RickAndMortyResponse<Character>
}