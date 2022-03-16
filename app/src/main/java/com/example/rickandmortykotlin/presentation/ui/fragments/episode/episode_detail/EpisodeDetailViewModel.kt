package com.example.rickandmortykotlin.presentation.ui.fragments.episode.episode_detail

import com.example.rickandmortykotlin.common.base.BaseViewModel
import com.example.rickandmortykotlin.data.network.models.episode.Episode
import com.example.rickandmortykotlin.data.repositories.EpisodeRepository
import com.example.rickandmortykotlin.presentation.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EpisodeDetailViewModel (
    private val repository: EpisodeRepository
): BaseViewModel(){
    private val _episodeDetailState = MutableStateFlow<UIState<Episode>>(UIState.Loading())
    val episodeDetailState: StateFlow<UIState<Episode>> = _episodeDetailState

    fun fetchEpisodeId(id: Int) {
        _episodeDetailState.subscribeTo {
            repository.fetchDetailEpisode(id)
        }
    }
}