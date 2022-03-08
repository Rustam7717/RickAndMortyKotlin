package com.example.rickandmortykotlin.data.network.pagingsources

import com.example.rickandmortykotlin.data.network.models.location.Location
import com.example.rickandmortykotlin.data.network.apiservices.LocationApiService
import com.example.rickandmortykotlin.common.base.BasePagingSource

class LocationPagingSource(
    private val services: LocationApiService
): BasePagingSource<Location>({
    services.fetchLocations(it)

})