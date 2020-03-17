package com.khs.noteexample.note.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.repository.NoteRepository

class WriteViewModel :AndroidViewModel{

    private val noteRepository:NoteRepository

    constructor(application: Application):super(application){
        noteRepository = NoteRepository.getInstance(application)
    }

    fun insertItem(item:NoteModel){
        noteRepository.insert(item)
    }

}