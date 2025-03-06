package com.example.racetracker

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//viewmodel will hold the data for ui as well as the biz logic
//view=UI and model=data
class HomeViewModel:ViewModel() {

    var TAG = HomeViewModel::class.java.simpleName

    lateinit var timer: CountDownTimer


    var count = 0

    //made seconds as observable
    //seconds is a public variable which can't be changed & _seconds is a private variable which can be channged within the class
   //this approach of having one changeable private  variable and other unchangeable public variable is known as backing property in kotlin
    val _seconds = MutableLiveData<Int>()//mutable = changed

  //  val seconds:LiveData<Int> = _seconds.ge


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
                _seconds.value = timeRemainning.toInt()

                Log.i(TAG,"seconds value ="+_seconds)
            }

            override fun onFinish() {
                Log.i(TAG,"timer finished")
            }

        }.start()
    }

}