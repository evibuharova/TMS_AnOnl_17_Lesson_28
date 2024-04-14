package com.example.tms_anonl_17_lesson_28.data

import retrofit2.http.GET
import retrofit2.http.Path



interface DisneyService {
    @GET("character")
    suspend fun getCharacters(): DisneyCharactersDto

    @GET("character/{id}")
    suspend fun getCharacter(@Path ("id") id: Int): DisneyCharacterDto
}