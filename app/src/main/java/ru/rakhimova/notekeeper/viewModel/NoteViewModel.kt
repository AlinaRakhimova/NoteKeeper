package ru.rakhimova.notekeeper.viewModel

import android.arch.lifecycle.Observer
import ru.rakhimova.notekeeper.data.NotesRepository
import ru.rakhimova.notekeeper.data.entity.Note
import ru.rakhimova.notekeeper.data.model.NoteResult

class NoteViewModel : BaseViewModel<Note?, NoteViewState>() {

    init {
        viewStateLiveData.value = NoteViewState()
    }

    private var pendingNote: Note? = null

    fun save(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        if (pendingNote != null) {
            NotesRepository.saveNote(pendingNote!!)
        }
    }

    fun loadNote(noteId: String) {
        NotesRepository.getNoteById(noteId).observeForever(Observer<NoteResult> {
            if (it == null) return@Observer
            when (it) {
                is NoteResult.Success<*> -> viewStateLiveData.value = NoteViewState(note = it.data as? Note)
                is NoteResult.Error -> viewStateLiveData.value = NoteViewState(error = it.error)
            }
        })
    }
}
