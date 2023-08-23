package com.example.noteapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.database.Note
import com.example.noteapp.database.NoteRepository

class MainViewModel(private val repository: NoteRepository): ViewModel() {
    val getAllNote: LiveData<List<Note>> = repository.getAll()

    fun addNote(note: Note) = repository.addNote(note)

    fun updateNote(note: Note) = repository.updateNote(note)

    fun deleteNote(note: Note) = repository.deleteNote(note)

}

class ViewModelFactory private constructor(private val repository: NoteRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(repository: NoteRepository): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(repository)
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }

    @Suppress
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}