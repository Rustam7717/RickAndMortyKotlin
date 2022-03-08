package com.example.rickandmortykotlin.data.repositories


import com.example.rickandmortykotlin.common.base.BaseRepository
import com.example.rickandmortykotlin.data.network.apiservices.CharacterApiService
import com.example.rickandmortykotlin.data.network.pagingsources.CharacterPagingSource
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharacterApiService
) : BaseRepository() {


    fun fetchCharacters() = doPagingRequest(CharacterPagingSource(service))

}