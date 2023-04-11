package com.bignerdranch.android.myfactorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state


    fun calculate(number: String) {
        _state.value = State(isInProgress = true)
        if (number.isNullOrEmpty()) {
            _state.value = State(isError = true)
            return
        }
        viewModelScope.launch {
            val calLong = number.toLong()
//            calcylate
            delay(5000)
            _state.value = State(isFactorial = number.toString())

        }

    }

}