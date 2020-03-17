package com.khs.noteexample.note.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao{
    @Insert
    fun insert(noteEntity: NoteEntity)

    @Update
    fun update(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)

    @Query("DELETE FROM note_table")
    fun deleteAll()

    @Query("SELECT * FROM note_table")
    fun getAll():LiveData<List<NoteEntity>>
}