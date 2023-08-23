package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.database.Note
import com.example.noteapp.database.NoteRepository
import com.example.noteapp.viewmodel.MainViewModel
import com.example.noteapp.viewmodel.ViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvNote: RecyclerView
    private lateinit var fab: FloatingActionButton

    private val mainViewModel: MainViewModel by lazy {
        val repository = NoteRepository(application)
        val factory = ViewModelFactory.getInstance(repository)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNote = findViewById(R.id.rv_note)
        fab = findViewById(R.id.fab_add)

        rvNote.layoutManager = LinearLayoutManager(this)

        mainViewModel.getAllNote.observe(this) {
            setNote(it)
        }

        fab.setOnClickListener(this)
    }

    private fun setNote(notes: List<Note>?) {
        val noteArray = arrayListOf<Note>()
        notes?.forEach {
            noteArray.add(it)
        }
        rvNote.adapter = NoteAdapter(noteArray) {
            mainViewModel.deleteNote(it)
            Toast.makeText(this, "Note Removed!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab_add -> {
                val intent =  Intent(this, AddActivity::class.java)
                startActivity(intent)
            }
        }
    }
}