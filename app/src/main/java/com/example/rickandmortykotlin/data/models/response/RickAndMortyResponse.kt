package com.example.rickandmortykotlin.data.models.response

import com.example.rickandmortykotlin.data.models.Info
import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T>(

    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val results: ArrayList<T>
)