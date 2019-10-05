package ru.rakhimova.notekeeper.view.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.rakhimova.notekeeper.R
import ru.rakhimova.notekeeper.data.entity.Note
import ru.rakhimova.notekeeper.view.adapter.NotesAdapter
import ru.rakhimova.notekeeper.viewModel.MainViewModel
import ru.rakhimova.notekeeper.viewModel.MainViewState

class MainActivity : BaseActivity<List<Note>?, MainViewState>() {

    override val layoutRes = R.layout.activity_main

    override val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        rv_notes.layoutManager = GridLayoutManager(this, 2)
        adapter = NotesAdapter {
            NoteActivity.start(this, it)
        }
        rv_notes.adapter = adapter
        fab.setOnClickListener {
            NoteActivity.start(this)
        }
    }

    override fun renderData(data: List<Note>?) {
        data?.let {
            adapter.notes = it
        }
    }
}
