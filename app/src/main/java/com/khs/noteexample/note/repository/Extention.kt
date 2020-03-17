package com.khs.noteexample.note.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.room.NoteEntity


fun NoteRepository.toListModel(noteEntity:List<NoteEntity>):MutableList<NoteModel>{
    val itemList = mutableListOf<NoteModel>()
    noteEntity.map {
        itemList.add(NoteModel(it.noteId?:0,it.noteTitle?:"",it.noteContent?:""))
    }
    return itemList
}

fun NoteRepository.toLiveDataListModel(localList:LiveData<List<NoteEntity>>):LiveData<MutableList<NoteModel>>{
    return Transformations.map<List<NoteEntity>, MutableList<NoteModel>>(localList,::toListModel)
}

fun NoteRepository.toEntity(note:NoteModel): NoteEntity {
    return when(note.id){
        null ->{
            NoteEntity(note.title, note.content)
        }
        else->{
            NoteEntity(
                note.id!!,
                note.title ?: "",
                note.content ?: ""
            )
        }
    }
}