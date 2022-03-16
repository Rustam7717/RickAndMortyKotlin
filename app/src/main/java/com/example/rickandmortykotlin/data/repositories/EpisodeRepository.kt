package com.example.rickandmortykotlin.data.repositories

import com.example.rickandmortykotlin.common.base.BaseRepository
import com.example.rickandmortykotlin.data.network.apiservices.EpisodeApiService
import com.example.rickandmortykotlin.data.network.pagingsources.CharacterPagingSource
import com.example.rickandmortykotlin.data.network.pagingsources.EpisodePagingSource
import javax.inject.Inject

class EpisodeRepository (
    private val service: EpisodeApiService
) : BaseRepository() {

    fun fetchDetailEpisode(id: Int) = doRequest {
        service.fetchEpisodeId(id)
    }

    fun fetchEpisodes() = doPagingRequest(EpisodePagingSource(service))
}