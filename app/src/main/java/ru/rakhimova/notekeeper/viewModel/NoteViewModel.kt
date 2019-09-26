package ru.rakhimova.notekeeper.viewModel

import android.arch.lifecycle.ViewModel
import ru.rakhimova.notekeeper.data.NotesRepository
import ru.rakhimova.notekeeper.data.entity.Note

class NoteViewModel : ViewModel() {

    private var pendingNote: Note? = null

    fun save(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        if (pendingNote != null) {
            NotesRepository.saveNote(pendingNote!!)
        }
    }
}
