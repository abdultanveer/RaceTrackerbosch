package com.example.racetracker

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow

//data holder-- biz logic
class HomeViewModel : ViewModel(){
    var TAG = HomeViewModel::class.java.simpleName


    lateinit var timer: CountDownTimer
    //i don't  want _seconds to be changed from outside this class
    private val _seconds = MutableStateFlow(0)

    // Publicly exposed StateFlow (read-only)
    val seconds: StateFlow<Int> = _seconds

    // Function to update the seconds value
    fun updateSeconds(value: Int) {
        _seconds.value = value
    }

    var count = 0

    fun incrementCounter(){
        count++
    }

    fun startTimer(){
        timer = object :CountDownTimer(10_000,1_000){

            override fun onTick(timeRemainning: Long) {
                _seconds.value = timeRemainning.toInt()

                Log.i(TAG,"seconds value ="+_seconds)
            }

            override fun onFinish() {
                Log.i(TAG,"timer finished")
            }

        }.start()
    }



    override fun onCleared() {
        super.onCleared()
    }


}