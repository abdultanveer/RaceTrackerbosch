package com.example.racetracker

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
//viewmodel will hold the data for ui as well as the biz logic
//view=UI and model=data
class HomeViewModel:ViewModel() {

    var TAG = HomeViewModel::class.java.simpleName

    lateinit var timer: CountDownTimer


    var count = 0
    var _seconds = 0


    fun incrementCounter(){
        count++
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("homeviewmodel","viewmodel was flushed")
    }

    fun startTimer(){
        timer = object :CountDownTimer(10_000,1_000){

            override fun onTick(timeRemainning: Long) {
                _seconds = timeRemainning.toInt()

                Log.i(TAG,"seconds value ="+_seconds)
            }

            override fun onFinish() {
                Log.i(TAG,"timer finished")
            }

        }.start()
    }

}