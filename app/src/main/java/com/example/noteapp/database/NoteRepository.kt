package com.example.noteapp.database

import android.app.Application
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {
    private val noteDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        noteDao = NoteDatabase.getDatabase(application).noteDao()
    }

    fun getAll(): LiveData<List<Note>> = noteDao.getAll()

    fun addNote(note: Note) = executorService.execute { noteDao.addNote(note) }

    fun updateNote(note: Note) = executorService.execute { noteDao.updateNote(note) }

    fun deleteNote(note: Note) = executorService.execute { noteDao.deleteNote(note) }

}