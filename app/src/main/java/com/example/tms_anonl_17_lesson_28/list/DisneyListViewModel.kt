package com.example.tms_anonl_17_lesson_28.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_anonl_17_lesson_28.SingleLiveEvent
import com.example.tms_anonl_17_lesson_28.data.DisneyRepository
import com.example.tms_anonl_17_lesson_28.list.DIsneyListFragment.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DisneyListViewModel @Inject constructor(
    private val repository: DisneyRepository
) : ViewModel() {
    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state
    val ivent = SingleLiveEvent<DIsneyListFragment.Ivent>()
    fun onAction(action: DIsneyListFragment.Action) {
        when (action) {
            is DIsneyListFragment.Action.OnItemClick -> {
                ivent.value = DIsneyListFragment.Ivent.GotoDetails(action.id)
            }
        }
    }

    init {
        viewModelScope.launch(Dispatchers.Main)
        {
            _state.value = DIsneyListFragment.State.Progress
            val newCharacters: List<DisneyCharacter>
            withContext(Dispatchers.IO) {
                newCharacters = repository.getCharacters()
            }
            _state.value = State.Characters(newCharacters)
        }
    }
}

