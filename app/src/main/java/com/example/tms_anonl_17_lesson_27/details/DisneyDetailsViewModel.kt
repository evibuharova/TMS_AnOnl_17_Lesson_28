package com.example.tms_anonl_17_lesson_27.details

import android.telecom.Call.Details
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_anonl_17_lesson_27.data.DisneyRepository
import com.example.tms_anonl_17_lesson_27.details.DisneyDitailsFragment.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DisneyDetailsViewModel @Inject constructor(
    private val repository: DisneyRepository
) : ViewModel() {
    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    fun onAction(action: DisneyDitailsFragment.Action) {
        when (action) {
            DisneyDitailsFragment.Action.BackPress -> {}
            is DisneyDitailsFragment.Action.Init -> {
                viewModelScope.launch(Dispatchers.Main)
                {
                    _state.value = State.Progress
                    val newCharacter: DisneyCharacterDetails
                    withContext(Dispatchers.IO) {
                        newCharacter = repository.getDetails(action.id)
                    }
                    _state.value = State.Character(
                        name = newCharacter.name,
                        films = newCharacter.films.joinToString(),
                        imageUrl = newCharacter.imageUrl ?: ""
                    )
                }
            }
        }
    }
}

