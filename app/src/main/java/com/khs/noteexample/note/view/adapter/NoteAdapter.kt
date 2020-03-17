package com.khs.noteexample.note.view.adapter

import android.content.Context
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.khs.noteexample.R
import com.khs.noteexample.databinding.NoteBinder
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.handlers.NoteRecyclerViewHandlers
import com.khs.noteexample.note.view.holder.NoteVIewHolder

class NoteAdapter(
    val context: Context
):RecyclerView.Adapter<NoteVIewHolder>(){

    private lateinit var noteBinder: NoteBinder
    private var noteList:MutableList<NoteModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVIewHolder {
        noteBinder = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_note,parent,false)
        noteBinder.handlers = NoteRecyclerViewHandlers(context)
        return NoteVIewHolder(context, noteBinder)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteVIewHolder, position: Int) {
        noteBinder.note = noteList[position]
        holder.bindDataToVIewHolder(noteList[position],position)
    }

    fun setItem(list:List<NoteModel>){
        noteList.clear()
        noteList.addAll(list)
        notifyDataSetChanged()
    }

}
