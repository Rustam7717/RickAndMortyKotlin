package com.example.rickandmortykotlin.presentation.ui.fragments.location.location_detail

import com.example.rickandmortykotlin.common.base.BaseViewModel
import com.example.rickandmortykotlin.data.network.models.episode.Episode
import com.example.rickandmortykotlin.data.network.models.location.Location
import com.example.rickandmortykotlin.data.repositories.LocationRepository
import com.example.rickandmortykotlin.presentation.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LocationDetailViewModel (
    private val repository: LocationRepository
    ): BaseViewModel() {
        private val _locationDetailState = MutableStateFlow<UIState<Location>>(UIState.Loading())
    val locationDetailState: StateFlow<UIState<Location>> = _locationDetailState

    fun fetchLocationId(id: Int) {
        _locationDetailState.subscribeTo {
            repository.fetchDetailLocation(id)
        }
    }
}
