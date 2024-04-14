package com.example.tms_anonl_17_lesson_28

import com.example.tms_anonl_17_lesson_28.data.DIsneyRetrofit
import com.example.tms_anonl_17_lesson_28.data.DisneyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
 class HiltMainModule {

    @Provides
    fun providesRetrofit(): DIsneyRetrofit = DIsneyRetrofit()

    @Provides
    fun providesRepository(retrofit: DIsneyRetrofit) = DisneyRepository(retrofit)
}