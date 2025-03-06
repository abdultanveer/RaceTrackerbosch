package com.example.racetracker

import androidx.lifecycle.ViewModel
//viewmodel will hold the data for ui as well as the biz logic
//view=UI and model=data
class HomeViewModel:ViewModel() {
    var count = 0

    fun incrementCounter(){
        count++
    }

}