package ru.rakhimova.notekeeper.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import ru.rakhimova.notekeeper.data.NotesRepository
import ru.rakhimova.notekeeper.data.entity.Note
import ru.rakhimova.notekeeper.data.model.NoteResult

class MainViewModel : BaseViewModel<List<Note>?, MainViewState>() {

    private val notesObserver = Observer<NoteResult> {
        if (it == null) return@Observer
        when (it) {
            is NoteResult.Success<*> -> {
                viewStateLiveData.value = MainViewState(notes = it.data as? List<Note>)
            }
            is NoteResult.Error -> {
                viewStateLiveData.value = MainViewState(error = it.error)
            }
        }
    }

    private val repositoryNotes = NotesRepository.getNotes()

    init {
        viewStateLiveData.value = MainViewState()
        repositoryNotes.observeForever(notesObserver)
    }


    override fun onCleared() {
        repositoryNotes.removeObserver(notesObserver)
    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData
}
