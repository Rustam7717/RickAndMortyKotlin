package com.example.rickandmortykotlin.data.network.pagingsources

import com.example.rickandmortykotlin.data.network.models.character.Character
import com.example.rickandmortykotlin.data.network.apiservices.CharacterApiService
import com.example.rickandmortykotlin.common.base.BasePagingSource

class CharacterPagingSource(
    private val services: CharacterApiService
) : BasePagingSource<Character>({ position ->
    services.fetchCharacters(position)

})