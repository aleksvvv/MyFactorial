package com.bignerdranch.android.myfactorial

sealed class State

object Error : State()
object Progress : State()
class Resulting(val factorial:String):State()