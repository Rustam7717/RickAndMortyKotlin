package com.example.rickandmortykotlin.data.repositories

import com.example.rickandmortykotlin.common.base.BaseRepository
import com.example.rickandmortykotlin.data.network.apiservices.LocationApiService
import com.example.rickandmortykotlin.data.network.pagingsources.LocationPagingSource
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val service: LocationApiService
) : BaseRepository() {

   fun fetchLocations() = doPagingRequest(LocationPagingSource(service))

}