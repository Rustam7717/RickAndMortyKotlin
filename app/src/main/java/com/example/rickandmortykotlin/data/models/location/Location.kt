package com.example.rickandmortykotlin.data.models.location

import com.example.rickandmortykotlin.ui.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class Location(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("dimension")
    val dimension: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String

) : IBaseDiffModel

