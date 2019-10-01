package ru.rakhimova.notekeeper.viewModel

import ru.rakhimova.notekeeper.BaseViewState
import ru.rakhimova.notekeeper.data.entity.Note

class NoteViewState(note: Note? = null, error: Throwable? = null) : BaseViewState<Note?>(note, error)