package com.khs.noteexample.note.handlers

import android.content.Context
import android.view.View
import com.khs.noteexample.databinding.WriteBinder
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.view.NoteActivity
import com.khs.noteexample.note.viewmodel.WriteViewModel

class WriteHandlers(
    val context: Context,
    val binder: WriteBinder,
    val viewModel:WriteViewModel){

    fun onApplyButton(view: View){
        val item = NoteModel(binder.editTitle.text.toString(),binder.editContent.text.toString())
        viewModel.insertItem(item)
        (context as NoteActivity).supportFragmentManager.popBackStack()
    }

}