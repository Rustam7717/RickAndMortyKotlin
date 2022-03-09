package com.example.rickandmortykotlin.presentation.ui.fragments.character.character_detail

import com.example.rickandmortykotlin.data.repositories.CharacterRepository
import com.example.rickandmortykotlin.common.base.BaseViewModel
import com.example.rickandmortykotlin.data.network.models.character.Character
import com.example.rickandmortykotlin.presentation.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val repository: CharacterRepository
) : BaseViewModel() {

    private val _characterDetailState = MutableStateFlow<UIState<Character>>(UIState.Loading())
    val characterDetailState: StateFlow<UIState<Character>> = _characterDetailState

    fun fetchCharacterId(id: Int) {
        _characterDetailState.subscribeTo {
            repository.fetchDetailCharacter(id)
        }
    }

//    private val _characterState = MutableStateFlow<UIState<Character>>(UIState.Loading)
//    val characterState: StateFlow<UIState<Character>> = _characterState

//    fun fetchCharacter(id: Int){
//        _characterState.subscribeTo {
//            repository.fetchCharacter(id)
//        }
//
//    }
}