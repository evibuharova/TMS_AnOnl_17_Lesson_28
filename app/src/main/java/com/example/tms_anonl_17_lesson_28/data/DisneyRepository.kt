package com.example.tms_anonl_17_lesson_28.data

import com.example.tms_anonl_17_lesson_28.details.DisneyCharacterDetails
import com.example.tms_anonl_17_lesson_28.list.DisneyCharacter
import javax.inject.Inject

class DisneyRepository @Inject constructor(
    private val retrofit: DIsneyRetrofit
) {
    suspend fun getCharacters(): List<DisneyCharacter> {
        return retrofit.service.getCharacters().data.map { charData ->
            DisneyCharacter(
                id = charData.Id ?: 0,
                name = charData.name ?: "",
                films = charData.films,
                imageUrl = charData.imageUrl
            )
        }
    }

    suspend fun getDetails(id: Int): DisneyCharacterDetails {
        return retrofit.service.getCharacter(id).data.let { charData ->
            DisneyCharacterDetails(
                id = charData.Id ?: 0,
                name = charData.name ?: "",
                films = charData.films,
                imageUrl = charData.imageUrl
            )
        }
    }

}