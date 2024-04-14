package com.example.tms_anonl_17_lesson_28.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DisneyCharactersDto (

  @SerialName("info" ) var info : DIsneyPageInfoDto?           = DIsneyPageInfoDto(),
  @SerialName("data" ) var data : ArrayList<DisneyCharDataDto> = arrayListOf()

)