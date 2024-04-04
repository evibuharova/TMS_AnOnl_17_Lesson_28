package com.example.tms_anonl_17_lesson_25.add

import androidx.lifecycle.ViewModel
import com.example.tms_anonl_17_lesson_25.Note
import com.example.tms_anonl_17_lesson_25.NoteHolder
import com.example.tms_anonl_17_lesson_25.SingleLiveEvent
import com.example.tms_anonl_17_lesson_25.add.NoteAddFragment.Action
import com.example.tms_anonl_17_lesson_25.add.NoteAddFragment.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NoteAddViewModel @Inject constructor(
    private val noteHolder: NoteHolder
) : ViewModel() {
    val event = SingleLiveEvent<Event>()

    fun onAction(action: Action) = when (action) {
        is Action.SaveClick -> {
            val newMote = Note(action.text, action.header, Date().toString())
            noteHolder.notes.add(newMote)
            event.value = Event.GoBack
        }
    }
}
