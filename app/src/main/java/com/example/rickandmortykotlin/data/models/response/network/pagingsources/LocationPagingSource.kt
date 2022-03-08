package com.example.rickandmortykotlin.data.models.response.network.pagingsources

import com.example.rickandmortykotlin.data.models.location.Location
import com.example.rickandmortykotlin.data.models.response.network.apiservices.LocationApiService
import com.example.rickandmortykotlin.data.models.response.network.pagingsources.base.BasePagingSource

class LocationPagingSource(
    private val services: LocationApiService
): BasePagingSource<Location>({
    services.fetchLocations(it)

})