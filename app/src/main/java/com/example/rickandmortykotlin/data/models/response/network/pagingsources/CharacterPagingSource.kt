package com.example.rickandmortykotlin.data.models.response.network.pagingsources

import com.example.rickandmortykotlin.data.models.character.Character
import com.example.rickandmortykotlin.data.models.response.network.apiservices.CharacterApiService
import com.example.rickandmortykotlin.data.models.response.network.pagingsources.base.BasePagingSource

class CharacterPagingSource(
    private val services: CharacterApiService
) : BasePagingSource<Character>({ position ->
    services.fetchCharacters(position)

})