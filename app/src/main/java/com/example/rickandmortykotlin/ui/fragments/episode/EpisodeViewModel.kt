package com.example.rickandmortykotlin.ui.fragments.episode

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortykotlin.data.repositories.EpisodeRepository
import com.example.rickandmortykotlin.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val repository: EpisodeRepository
): BaseViewModel(){

    fun fetchEpisodes() = repository.fetchEpisodes().cachedIn(viewModelScope)
}