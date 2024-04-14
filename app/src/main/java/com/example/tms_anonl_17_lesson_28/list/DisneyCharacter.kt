package com.example.tms_anonl_17_lesson_28.list

data class DisneyCharacter(
    val id: Int,
    val name: String,
    val films: List<String>,
    val imageUrl: String?
)