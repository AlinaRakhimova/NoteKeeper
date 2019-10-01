package ru.rakhimova.notekeeper.data

import ru.rakhimova.notekeeper.data.entity.Note
import ru.rakhimova.notekeeper.data.provider.FireStoreProvider
import ru.rakhimova.notekeeper.data.provider.RemoteDataProvider

object NotesRepository {

    private val remoteProvider: RemoteDataProvider = FireStoreProvider()

    fun getNotes() = remoteProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = remoteProvider.saveNote(note)
    fun getNoteById(id: String) = remoteProvider.getNoteById(id)
}
