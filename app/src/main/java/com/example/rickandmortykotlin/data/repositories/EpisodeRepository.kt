package com.example.rickandmortykotlin.data.repositories

import com.example.rickandmortykotlin.common.base.BaseRepository
import com.example.rickandmortykotlin.data.network.apiservices.EpisodeApiService
import com.example.rickandmortykotlin.data.network.pagingsources.EpisodePagingSource
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val service: EpisodeApiService
) : BaseRepository() {

   fun fetchEpisodes() = doPagingRequest(EpisodePagingSource(service))
}