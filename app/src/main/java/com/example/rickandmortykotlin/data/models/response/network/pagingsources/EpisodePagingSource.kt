package com.example.rickandmortykotlin.data.models.response.network.pagingsources


import com.example.rickandmortykotlin.data.models.episode.Episode
import com.example.rickandmortykotlin.data.models.response.network.apiservices.EpisodeApiService
import com.example.rickandmortykotlin.data.models.response.network.pagingsources.base.BasePagingSource

class EpisodePagingSource (
    private val services: EpisodeApiService
): BasePagingSource<Episode> ({position ->
    services.fetchEpisodes(position)
})




