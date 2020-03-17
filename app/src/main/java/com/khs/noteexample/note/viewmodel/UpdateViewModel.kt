package com.khs.noteexample.note.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.repository.NoteRepository

class UpdateViewModel:AndroidViewModel{
    private var noteRepository: NoteRepository

    constructor(application: Application):super(application){
        noteRepository = NoteRepository.getInstance(application)
    }

    fun updateItem(item:NoteModel){
        noteRepository.update(item)
    }

    fun deleteItem(item:NoteModel){
        noteRepository.delete(item)
    }
}