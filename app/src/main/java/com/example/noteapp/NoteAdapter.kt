package com.example.noteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.database.Note

class NoteAdapter(private val noteArray: ArrayList<Note>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = noteArray.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cvTitle = holder.itemView.findViewById<TextView>(R.id.cv_title)
        val cvContent = holder.itemView.findViewById<TextView>(R.id.cv_content)

        cvTitle.text = noteArray[position].title
        cvContent.text = noteArray[position].content
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}