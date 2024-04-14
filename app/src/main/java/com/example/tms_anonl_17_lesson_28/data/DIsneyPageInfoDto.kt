package com.example.tms_anonl_17_lesson_28.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DIsneyPageInfoDto(

    @SerialName("count") var count: Int? = null,
    @SerialName("totalPages") var totalPages: Int? = null,
    @SerialName("previousPage") var previousPage: String? = null,
    @SerialName("nextPage") var nextPage: String? = null

)