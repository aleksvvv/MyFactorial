package com.bignerdranch.android.myfactorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigInteger
import kotlin.concurrent.thread
import kotlin.coroutines.suspendCoroutine

class MainViewModel : ViewModel() {
    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state


    fun calculate(number: String) {
        _state.value = Progress
        if (number.isNullOrEmpty()) {
            _state.value = Error
            return
        }
        viewModelScope.launch {
            val calLong = number.toLong()
            val result = factorial(calLong)
//            delay(1000)
            _state.value = Resulting(result)
        }
    }

    private suspend fun factorial(number: Long): String {

      return withContext(Dispatchers.Default){
           var result = BigInteger.ONE
           for (i in 1..number) {
               result = result.multiply(BigInteger.valueOf(i))
           }
          result.toString()
       }
    }
//    private suspend fun factorial(number: Long): BigInteger {
//
//        return suspendCoroutine {
//            thread {
//                var result = BigInteger.ONE
//                for (i in 1..number) {
//                    result = result.multiply(BigInteger.valueOf(i))
//                }
//                it.resumeWith(Result.success(result))
//            }
//        }
//    }
}