package com.khs.noteexample.note.handlers

import android.content.Context
import android.os.Bundle
import android.view.View
import com.khs.noteexample.R
import com.khs.noteexample.databinding.NoteBinder
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.view.NoteActivity
import com.khs.noteexample.note.view.fragment.UpdateFragment

class NoteRecyclerViewHandlers(val context: Context){
    fun onItemClicked(view: View,item:NoteModel){
        var updateFragment = UpdateFragment.newInstance()
        var bundle = Bundle()
        bundle.putParcelable("note",item)
        (context as NoteActivity).supportFragmentManager.beginTransaction()
            .add(R.id.container,updateFragment.apply { arguments=bundle })
            .addToBackStack("UpdateFragment")
            .commit()
    }
}