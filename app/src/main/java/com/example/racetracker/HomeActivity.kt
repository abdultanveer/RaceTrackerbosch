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
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    lateinit var countTv:TextView      //observer
    lateinit var viewModel:HomeViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        countTv = findViewById(R.id.tvHome)

        lifecycleScope.launch {
            viewModel.seconds.collectLatest { seconds ->
                countTv.text = seconds.toString()  // Updating UI
            }
        }



        // countTv.setText(""+viewModel.seconds)
    }

    fun incrementCount(view: View) {
        viewModel.startTimer()
    }


}