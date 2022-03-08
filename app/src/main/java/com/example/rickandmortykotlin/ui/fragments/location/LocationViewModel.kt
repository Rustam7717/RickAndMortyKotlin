package com.example.rickandmortykotlin.ui.fragments.location

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortykotlin.data.repositories.LocationRepository
import com.example.rickandmortykotlin.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val repository: LocationRepository
) : BaseViewModel(){

    fun fetchLocations() = repository.fetchLocations().cachedIn(viewModelScope)
}