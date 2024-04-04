package com.example.tms_anonl_17_lesson_25.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms_anonl_17_lesson_25.Note
import com.example.tms_anonl_17_lesson_25.NoteHolder
import com.example.tms_anonl_17_lesson_25.SingleLiveEvent
import com.example.tms_anonl_17_lesson_25.list.NoteListFragment.*
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val noteHolder: NoteHolder
) : ViewModel() {
    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state
    val event = SingleLiveEvent<Event>()

    init {
        noteHolder.notes.add(
            Note("examle note", "some random text", Date().toString())
        )
        _state.value = State.Initial(noteHolder.notes.toList())
    }

    fun onAction(action: Action) = when (action) {
        Action.Update -> {
            val oldNotes = (_state.value as? State.Notes)?.items
            if (oldNotes != noteHolder.notes) {
                event.value = Event.ShowSuccessMessage
            }
            _state.value = State.Notes(noteHolder.notes.toList())
        }

        Action.AddClick -> {
            event.value = Event.GoToAddScreen
        }
    }
}
