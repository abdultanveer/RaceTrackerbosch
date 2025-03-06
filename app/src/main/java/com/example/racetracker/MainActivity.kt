/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.racetracker

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.racetracker.ui.RaceTrackerApp
import com.example.racetracker.ui.theme.RaceTrackerTheme

class MainActivity : ComponentActivity() {
    var TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"created--chick in the egg--acquire resources")
        setContent {
            RaceTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    RaceTrackerApp()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"started--chick hatched-visbile--handle clicks")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG,"resumed--chick woken up--fetch data/restore the state")

    }

    override fun onPause() {
        super.onPause()
        Log.w(TAG,"paused--chick asleep--save the app state")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"stopped--frog hibernated--save email draft")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"destroyed--chick buried--release resources--close db")

    }


}
