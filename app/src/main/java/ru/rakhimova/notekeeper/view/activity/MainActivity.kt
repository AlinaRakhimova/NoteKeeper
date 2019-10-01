package ru.rakhimova.notekeeper.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.rakhimova.notekeeper.R
import ru.rakhimova.notekeeper.view.adapter.NotesAdapter
import ru.rakhimova.notekeeper.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        rv_notes.layoutManager = GridLayoutManager(this, 2)
        adapter = NotesAdapter {
            NoteActivity.start(this, it)
        }
        rv_notes.adapter = adapter

        viewModel.viewState().observe(this, Observer { value -> value?.let { adapter.notes = it.notes } })

        fab.setOnClickListener {
            NoteActivity.start(this)
        }
    }
}
