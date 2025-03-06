package com.example.racetracker

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

//factory design pattern

class HomeActivity : AppCompatActivity() {
    lateinit var homeTv:TextView
    lateinit var viewModel:HomeViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        //this is not instantiating homeviewmodel


        homeTv = findViewById(R.id.tvHome)
        homeTv.setText(""+viewModel._seconds)

    }

    fun incrementCount(view: View) {
        // viewModel.incrementCounter()
        viewModel.startTimer()
        homeTv.setText(""+viewModel._seconds)

    }
}