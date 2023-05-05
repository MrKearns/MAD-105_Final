package com.example.mad_105_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val summaryTitle = findViewById<TextView>(R.id.summaryTitle)
        val summaryDate = findViewById<TextView>(R.id.summaryDate)
        val summaryRating = findViewById<RatingBar>(R.id.summaryRatingBar)
        val summaryNotes = findViewById<TextView>(R.id.summaryNotes)
        val summaryTvMovie = findViewById<TextView>(R.id.summaryTvOrMovie)

        summaryTitle.text = intent.getStringExtra("title")
        summaryDate.text = intent.getStringExtra("date")
        summaryRating.rating = intent.getFloatExtra("rating", 0.0f)
        summaryNotes.text = intent.getStringExtra("summary")

    }
}