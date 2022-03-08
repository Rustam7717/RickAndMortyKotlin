package com.example.rickandmortykotlin.data.repositories


import com.example.rickandmortykotlin.data.models.response.network.apiservices.CharacterApiService
import com.example.rickandmortykotlin.data.models.response.network.pagingsources.CharacterPagingSource
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharacterApiService
) : BaseRepository() {


    fun fetchCharacters() = doPagingRequest(CharacterPagingSource(service))

}