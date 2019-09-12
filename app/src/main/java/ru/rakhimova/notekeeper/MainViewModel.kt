package ru.rakhimova.notekeeper

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val viewStateLiveData = MutableLiveData<String>()
    var count = 0

    init {
        viewStateLiveData.value = "Hello World!!!"
    }

    fun viewState(): LiveData<String> = viewStateLiveData

    fun buttonClick() {
        count++
        viewStateLiveData.value = count.toString()
    }
}