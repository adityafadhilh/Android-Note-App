package com.example.noteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.database.Note
import com.example.noteapp.database.NoteRepository
import com.example.noteapp.viewmodel.MainViewModel
import com.example.noteapp.viewmodel.ViewModelFactory

class NoteAdapter(private val noteArray: ArrayList<Note>, private val onClick: (Note) -> Unit) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = noteArray.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cvTitle.text = noteArray[position].title
        holder.cvContent.text = noteArray[position].content
        holder.delete.setOnClickListener {
            onClick(noteArray[position])
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cvTitle: TextView = itemView.findViewById(R.id.cv_title)
        val cvContent: TextView = itemView.findViewById(R.id.cv_content)
        val delete: ImageView = itemView.findViewById(R.id.icon_delete)
    }

}