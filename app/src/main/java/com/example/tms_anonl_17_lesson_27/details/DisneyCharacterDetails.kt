package com.example.tms_anonl_17_lesson_27.details

data class DisneyCharacterDetails(
    val id: Int,
    val name: String,
    val films: List<String>,
    val imageUrl: String?
)