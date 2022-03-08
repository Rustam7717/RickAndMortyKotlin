package com.example.rickandmortykotlin.ui.fragments.character.character_detail

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortykotlin.data.repositories.CharacterRepository
import com.example.rickandmortykotlin.ui.base.BaseViewModel

class CharacterDetailViewModel(
    private val repository: CharacterRepository
) : BaseViewModel(){

    fun fetchCharacter(id: Int){

    }
}