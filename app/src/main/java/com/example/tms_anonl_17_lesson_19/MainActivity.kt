package com.example.tms_anonl_17_lesson_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

class MainActivity : AppCompatActivity() {

    private val adapter = NotesRecyclerViewAdapter(
        mutableListOf(
            Note("Example header", "Some long example text", Date().toString()),
            Note("22 Example header", "22 Some long example text", Date().toString()),
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.Recycler)
        recyclerView.adapter = adapter

        val header = findViewById<EditText>(R.id.headerEditText)
        val text = findViewById<EditText>(R.id.textEditText)
        val button = findViewById<Button>(R.id.addButton)
        button.setOnClickListener {
            val newMote = Note(
                header.text?.toString() ?: "",
                text.text?.toString() ?: "",
                Date().toString()
            )
            adapter.addItem(newMote)
            header.setText("")
            text.setText("")
        }
    }
}