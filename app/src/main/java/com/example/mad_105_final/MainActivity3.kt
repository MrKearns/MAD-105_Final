package com.example.mad_105_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var iconImage = findViewById<ImageView>(R.id.summaryTvOrMovieImage)
        val formatter = DateTimeFormatter.ofPattern(("MM-dd-yyyy"))

        val summaryTitle = findViewById<TextView>(R.id.summaryTitle)
        val summaryDate = findViewById<TextView>(R.id.summaryDate)
        val summaryRating = findViewById<RatingBar>(R.id.summaryRatingBar)
        val summaryNotes = findViewById<TextView>(R.id.summaryNotes)
        val summaryTvMovie = findViewById<TextView>(R.id.summaryTvOrMovie)
        val backButton = findViewById<Button>(R.id.summaryEditButton)

        var date = LocalDate.parse(intent.getStringExtra("date"))

        summaryDate.text = date?.format(formatter)

        summaryTitle.text = intent.getStringExtra("title")
        //summaryDate.text = intent.getStringExtra("date")
        summaryRating.rating = intent.getFloatExtra("rating", 0.0f)
        summaryNotes.text = intent.getStringExtra("summary")
        summaryTvMovie.text = intent.getStringExtra("tvOrMovie")



        if (summaryNotes.text.isBlank()){
            summaryNotes.text = "(No Notes)"
        } else {
           print("all good here")
        }

        if (summaryTvMovie.text == "TV Show") {
            iconImage.setImageResource(R.drawable.tv_icon)
        } else if (summaryTvMovie.text == "Movie") {
            iconImage.setImageResource(R.drawable.movie_icon)
        } else {
            iconImage.setImageResource(R.drawable.movie_icon)
        }

        // ---- BACK BUTTON ----
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}