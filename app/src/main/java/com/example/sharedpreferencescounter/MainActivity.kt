package com.example.sharedpreferencescounter

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvCounter: TextView
    private val PREFS_NAME = "CounterPrefs"
    private val COUNTER_KEY = "counter_value"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCounter = findViewById(R.id.tvCounter)

        val sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        var counterValue = sharedPreferences.getInt(COUNTER_KEY, 0)

        counterValue++


        val editor = sharedPreferences.edit()
        editor.putInt(COUNTER_KEY, counterValue)
        editor.apply()


        tvCounter.text = counterValue.toString()
    }
}