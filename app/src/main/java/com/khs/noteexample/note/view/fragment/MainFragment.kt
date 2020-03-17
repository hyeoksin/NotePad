package com.khs.noteexample.note.view.fragment

import android.database.DatabaseUtils
import android.database.Observable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khs.noteexample.R
import com.khs.noteexample.databinding.MainBinder
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.handlers.MainHandlers
import com.khs.noteexample.note.view.adapter.NoteAdapter
import com.khs.noteexample.note.viewmodel.MainViewModel

class MainFragment:Fragment(){

    private lateinit var binding:MainBinder
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter:NoteAdapter

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
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        adapter = NoteAdapter(context = context!!)
        binding.noteRecyclerview.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding.noteRecyclerview.adapter = adapter
        viewModel.getItem().observe(viewLifecycleOwner, object : Observer<List<NoteModel>> {
            override fun onChanged(list: List<NoteModel>) {
                binding.noteRecyclerview.removeAllViews()
                adapter.setItem(list)
            }
        })
        binding.noteRecyclerview.setHasFixedSize(true)
    }

}