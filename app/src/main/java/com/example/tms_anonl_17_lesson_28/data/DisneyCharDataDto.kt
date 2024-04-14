package com.example.tms_anonl_17_lesson_28.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DisneyCharDataDto(

    @SerialName("_id") var Id: Int? = null,
    @SerialName("films") var films: ArrayList<String> = arrayListOf(),
    @SerialName("shortFilms") var shortFilms: ArrayList<String> = arrayListOf(),
    @SerialName("tvShows") var tvShows: ArrayList<String> = arrayListOf(),
    @SerialName("videoGames") var videoGames: ArrayList<String> = arrayListOf(),
    @SerialName("parkAttractions") var parkAttractions: ArrayList<String> = arrayListOf(),
    @SerialName("allies") var allies: ArrayList<String> = arrayListOf(),
    @SerialName("enemies") var enemies: ArrayList<String> = arrayListOf(),
    @SerialName("sourceUrl") var sourceUrl: String? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("imageUrl") var imageUrl: String? = null,
    @SerialName("createdAt") var createdAt: String? = null,
    @SerialName("updatedAt") var updatedAt: String? = null,
    @SerialName("url") var url: String? = null,
    @SerialName("__v") var _v: Int? = null

)