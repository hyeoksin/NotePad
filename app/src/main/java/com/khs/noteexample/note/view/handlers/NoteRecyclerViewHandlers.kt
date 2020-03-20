package com.khs.noteexample.note.view.handlers

import android.content.Context
import android.os.Bundle
import android.view.View
import com.khs.noteexample.R
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.view.NoteActivity
import com.khs.noteexample.note.view.adapter.NoteAdapter
import com.khs.noteexample.note.view.fragment.UpdateFragment
import com.khs.noteexample.note.view.holder.NoteVIewHolder

class NoteRecyclerViewHandlers(
    val context: Context,
    val holder: NoteVIewHolder,
    val noteAdapter: NoteAdapter
){
    fun onItemClicked(view: View,item:NoteModel){
        val updateFragment = UpdateFragment.newInstance()
        val item = noteAdapter.getNoteAt(holder.adapterPosition)
        (context as NoteActivity).supportFragmentManager.beginTransaction()
            .add(R.id.container,updateFragment.apply {
                arguments=Bundle().apply {
                    putParcelable("note",item)
                } })
            .addToBackStack("UpdateFragment")
            .commit()
    }
}