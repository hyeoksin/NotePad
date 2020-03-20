package com.khs.noteexample.note.view.fragment

import android.database.DatabaseUtils
import android.database.Observable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khs.noteexample.R
import com.khs.noteexample.databinding.MainBinder
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.view.handlers.MainHandlers
import com.khs.noteexample.note.view.handlers.NoteItemTouchHandlers
import com.khs.noteexample.note.view.adapter.NoteAdapter
import com.khs.noteexample.note.viewmodel.MainViewModel

class MainFragment:Fragment(){

    private lateinit var binding:MainBinder
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerview:RecyclerView
    private lateinit var adapter:NoteAdapter
    private lateinit var itemTouchHelper: ItemTouchHelper

    companion object{
        private var instance:MainFragment?=null
        fun newInstance():MainFragment{
            return instance?:MainFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.handlers = MainHandlers(context!!)
        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        setRecyclerView()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel()
    }

    private fun setRecyclerView() {
        adapter = NoteAdapter(context!!)
        recyclerview = binding.noteRecyclerview
        recyclerview.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        recyclerview.adapter = adapter
        recyclerview.setHasFixedSize(true)
        itemTouchHelper = ItemTouchHelper(NoteItemTouchHandlers(viewModel,adapter))
        itemTouchHelper.attachToRecyclerView(recyclerview)
    }

    private fun observeViewModel() {
        viewModel.getItem().observe(this, Observer {list->
            Log.d("DEBUG","BEFORE: "+ adapter.itemCount.toString())
            recyclerview.adapter = adapter
            adapter?.submitList(list)
            Log.d("DEBUG","AFTER: "+ adapter.itemCount.toString())
        })
    }


}