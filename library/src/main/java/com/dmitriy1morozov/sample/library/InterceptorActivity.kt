package com.dmitriy1morozov.sample.library

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class InterceptorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag", "onCreate: HAPPENED")
        Log.d("tag", "onCreate: action = ${intent.action}")
        Log.d("tag", "onCreate: data = ${intent.data}")

        intent.component = null
        startActivity(intent)
        finish()
    }
}