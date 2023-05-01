package com.example.mad_105_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val summaryTitle = findViewById<TextView>(R.id.summaryTitle)

        summaryTitle.text = intent.getStringExtra("title")
    }
}