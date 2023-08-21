package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.database.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rvNote: RecyclerView
    private lateinit var fab: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNote = findViewById(R.id.rv_note)
        fab = findViewById(R.id.fab_add)

        rvNote.layoutManager = LinearLayoutManager(this)
        rvNote.adapter = NoteAdapter(noteArray)
    }

    private var noteArray = arrayListOf<Note>(
        Note(1, "Test", "suahsuahshanusahsanjsnausna"),
        Note(2, "Test", "sasasasasadsadsasasasasasasasas"),
        Note(3, "Test", "dasasadfsdasdadadadadadadadadadad"),
        Note(4, "Test", "dasasadfsdasdadadadadadadadadadad"),
        Note(5, "Test", "dasasadfsdasdadadadadadadadadadad"),
        Note(6, "Test", "dasasadfsdasdadadadadadadadadadad"),
    )
}