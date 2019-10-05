package ru.rakhimova.notekeeper.data.provider

import android.arch.lifecycle.LiveData
import ru.rakhimova.notekeeper.data.entity.Note
import ru.rakhimova.notekeeper.data.model.NoteResult

interface RemoteDataProvider {

    fun subscribeToAllNotes(): LiveData<NoteResult>
    fun getNoteById(id: String): LiveData<NoteResult>
    fun saveNote(note: Note): LiveData<NoteResult>
}
