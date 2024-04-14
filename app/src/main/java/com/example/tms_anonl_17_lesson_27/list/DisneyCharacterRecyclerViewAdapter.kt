package com.example.tms_anonl_17_lesson_27.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tms_anonl_17_lesson_27.R

class DisneyCharacterRecyclerViewAdapter(val onClickListener:(Int)->Unit) : RecyclerView.Adapter<DisneyCharacterViewHolder>() {
    private val differ = AsyncListDiffer(this, DisneyDiffUtilCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisneyCharacterViewHolder {
        val listLayoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_character_list_item, parent, false)
        return DisneyCharacterViewHolder(listLayoutView, onClickListener)
    }

    override fun onBindViewHolder(holder: DisneyCharacterViewHolder, position: Int) {
        val note = differ.currentList[position]
        holder.bind(note)
    }

    override fun getItemCount() = differ.currentList.size

    fun update(newItems: List<DisneyCharacter>) {
        differ.submitList(newItems)
    }
}

class DisneyCharacterViewHolder(itemView: View, val onClickListener:(Int)->Unit) : RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.findViewById(R.id.name)
    private val films: TextView = itemView.findViewById(R.id.films)
    private val image: ImageView = itemView.findViewById(R.id.image)
    fun bind(character: DisneyCharacter) {
        name.text = character.name
        films.text = character.films.joinToString(", ")
        Glide.with(itemView)
            .load(character.imageUrl)
            .into(image)
        itemView.setOnClickListener {onClickListener.invoke(character.id)}
    }
}