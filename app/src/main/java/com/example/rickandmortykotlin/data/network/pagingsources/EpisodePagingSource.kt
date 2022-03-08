package com.example.rickandmortykotlin.data.network.pagingsources


import com.example.rickandmortykotlin.data.network.models.episode.Episode
import com.example.rickandmortykotlin.data.network.apiservices.EpisodeApiService
import com.example.rickandmortykotlin.common.base.BasePagingSource

class EpisodePagingSource (
    private val services: EpisodeApiService
): BasePagingSource<Episode>({ position ->
    services.fetchEpisodes(position)
})




