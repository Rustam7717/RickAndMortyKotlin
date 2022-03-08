package com.example.rickandmortykotlin.data.repositories

import com.example.rickandmortykotlin.data.models.response.network.apiservices.EpisodeApiService
import com.example.rickandmortykotlin.data.models.response.network.pagingsources.EpisodePagingSource
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val service: EpisodeApiService
) : BaseRepository() {

   fun fetchEpisodes() = doPagingRequest(EpisodePagingSource(service))
}