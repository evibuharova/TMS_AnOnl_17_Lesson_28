package com.example.tms_anonl_17_lesson_28.list

import androidx.recyclerview.widget.DiffUtil

// создать обьет NoteDiffUtilCallback (он сравнивает две заметки в себе), переопределить два метода
//создать в адаптере differ и функцию аптейд, используя диффер.сабмит
//в майне заменить note на апдейт

object DisneyDiffUtilCallback : DiffUtil.ItemCallback<DisneyCharacter>() {
    override fun areItemsTheSame(oldItem: DisneyCharacter, newItem: DisneyCharacter): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: DisneyCharacter, newItem: DisneyCharacter): Boolean {
        return oldItem == newItem
    }
}