package com.khs.noteexample.note.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.repository.NoteRepository


class MainViewModel:AndroidViewModel{

    private var noteRepository: NoteRepository
    private var liveList:MutableLiveData<MutableList<NoteModel>> = MutableLiveData()

    constructor(application: Application):super(application){
        noteRepository = NoteRepository.getInstance(application)
    }

    @Deprecated("Test")
    fun setItem(){
        var item = mutableListOf<NoteModel>()
        item.add(NoteModel("TEST1","TEST1"))
        item.add(NoteModel("TEST2","TEST2"))
        item.add(NoteModel("TEST3","TEST3"))
        liveList.value = item
    }

    fun getItem():LiveData<MutableList<NoteModel>>{
        // return liveList
        return noteRepository.getAll()
    }
}