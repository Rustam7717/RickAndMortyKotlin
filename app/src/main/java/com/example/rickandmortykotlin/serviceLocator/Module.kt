package com.example.rickandmortykotlin.serviceLocator

import com.example.rickandmortykotlin.data.network.RetrofitClient
import com.example.rickandmortykotlin.data.repositories.CharacterRepository
import com.example.rickandmortykotlin.data.repositories.EpisodeRepository
import com.example.rickandmortykotlin.data.repositories.LocationRepository
import com.example.rickandmortykotlin.presentation.ui.fragments.character.CharacterViewModel
import com.example.rickandmortykotlin.presentation.ui.fragments.character.character_detail.CharacterDetailViewModel
import com.example.rickandmortykotlin.presentation.ui.fragments.episode.EpisodeViewModel
import com.example.rickandmortykotlin.presentation.ui.fragments.episode.episode_detail.EpisodeDetailViewModel
import com.example.rickandmortykotlin.presentation.ui.fragments.location.LocationViewModel
import com.example.rickandmortykotlin.presentation.ui.fragments.location.location_detail.LocationDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

    val networkModule = module {
        single { RetrofitClient() }
        single { get<RetrofitClient>().provideCharacterApiService() }
        single { get<RetrofitClient>().provideEpisodeApiService() }
        single { get<RetrofitClient>().provideLocationApiService() }
    }
    val repositoriesModel = module {
        factory { CharacterRepository(get()) }
        factory { EpisodeRepository(get()) }
        factory { LocationRepository(get()) }
    }
    val viewModelModule = module {
        viewModel { CharacterViewModel(get()) }
        viewModel { EpisodeViewModel(get()) }
        viewModel { LocationViewModel(get()) }
        viewModel { CharacterDetailViewModel(get()) }
        viewModel { LocationDetailViewModel(get()) }
        viewModel { EpisodeDetailViewModel(get()) }
    }

