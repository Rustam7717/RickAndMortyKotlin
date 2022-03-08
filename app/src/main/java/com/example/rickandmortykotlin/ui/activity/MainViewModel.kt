package com.example.rickandmortykotlin.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortykotlin.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
//    private val repository: CharacterRepository
) : ViewModel() {

//    fun fetchCharacter(id: Int) = repository.fetchCharacters(id)
//
//    fun fetchCharacters() = repository.fetchCharacters().cachedIn(viewModelScope)
}