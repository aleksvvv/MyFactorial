package com.bignerdranch.android.myfactorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean>
        get() = _error

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean>
        get() = _progress

    private val _factorial = MutableLiveData<String>()
    val factorial: LiveData<String>
        get() = _factorial

    fun calculate(number: String) {
        _progress.value = true
        if (number.isNullOrEmpty()) {
            _error.value = true
            _progress.value = false
            return
        }
        viewModelScope.launch {
            val calLong = number.toLong()
//            calcylate
            delay(5000)
            _progress.value = false
            _factorial.value = number
        }

    }

}