package com.example.tms_anonl_17_lesson_28.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DIsneyRetrofit @Inject constructor() {

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://api.disneyapi.dev/")
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    val service: DisneyService get() = retrofit.create(DisneyService::class.java)
}