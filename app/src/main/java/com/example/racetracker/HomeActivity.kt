package com.example.racetracker

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

//factory design pattern

class HomeActivity : AppCompatActivity() {
    lateinit var homeTv:TextView
    lateinit var viewModel:HomeViewModel

    //made textview as an observer
    var secsObserverphno: Observer<Int> = object : Observer<Int> {
        override fun onChanged(seconds: Int) {
            //receiving the update/notification
            homeTv.setText(seconds.toString())
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        //this is not instantiating homeviewmodel

        viewModel._seconds.observe(this, secsObserverphno);
        //me giving my phno to the postman



        homeTv = findViewById(R.id.tvHome)
        homeTv.setText(""+viewModel._seconds)

    }

    fun incrementCount(view: View) {
        // viewModel.incrementCounter()
        viewModel.startTimer()
        homeTv.setText(""+viewModel._seconds)

    }
}