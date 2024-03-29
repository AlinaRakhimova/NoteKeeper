package ru.rakhimova.notekeeper.viewModel

import ru.rakhimova.notekeeper.data.entity.Note

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null) : BaseViewState<List<Note>?>(notes, error)
