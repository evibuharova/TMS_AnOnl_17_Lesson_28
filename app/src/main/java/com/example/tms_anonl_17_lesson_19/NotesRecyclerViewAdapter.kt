package com.example.tms_anonl_17_lesson_19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRecyclerViewAdapter(
    private val notes: MutableList<Note>
): RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val listLayoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_layout, parent, false)
        return NoteViewHolder(listLayoutView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    override fun getItemCount() = notes.size

    fun addItem(note: Note) {
        notes.add(note)
        notifyItemInserted(notes.size-1)
    }
}