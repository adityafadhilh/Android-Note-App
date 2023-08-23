package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.database.Note
import com.example.noteapp.database.NoteRepository
import com.example.noteapp.viewmodel.MainViewModel
import com.example.noteapp.viewmodel.ViewModelFactory
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class AddActivity : AppCompatActivity() {
    private lateinit var edtTitle: TextInputEditText
    private lateinit var edtContent: TextInputEditText
    private lateinit var topBar: MaterialToolbar

    private val mainViewModel: MainViewModel by lazy {
        val repository = NoteRepository(application)
        val factory = ViewModelFactory.getInstance(repository)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        edtTitle = findViewById(R.id.edt_title)
        edtContent = findViewById(R.id.edt_content)
        topBar = findViewById(R.id.top_bar_add)

        topBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.close -> {
                    finish()
                    true
                }
                R.id.add -> {
                    mainViewModel.addNote(
                        Note(title = edtTitle.text.toString(), content = edtContent.text.toString())
                    )
                    Toast.makeText(this, "Note Added!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                else -> {
                    false
                }
            }
        }



    }
}