package com.example.mad_105_final

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity2 : AppCompatActivity() {

    // I DON'T KNOW!
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //-------- VARS / VALS --------
        var movieOrTVChoice = ""

        var title = findViewById<TextView>(R.id.titleInput)
        var rating = findViewById<RatingBar>(R.id.starRating)
        var notes = findViewById<TextView>(R.id.notesInput)
        var movieOrTv = findViewById<Spinner>(R.id.movieOrTVSpinner)
        var dateWatched = findViewById<TextView>(R.id.dateWatched)
        var addButton = findViewById<Button>(R.id.addButton)

        val datePattern = Regex("""\d{2}-\d{2}-\d{4}""")

        val today = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern(("MM-dd-yyyy"))
        val todayFormatted = today.format(formatter)
        //println("------------$todayFormatted----------")

        // -- SET dateWatched TO DEFAULT TO TODAY'S DATE --
        val todayVariableString = getString(R.string.todaysDate, todayFormatted)
        dateWatched.text = todayVariableString
        //println("------------$todayVariableString----------")


        // -------- ADD TO LIST BUTTON --------
        addButton.setOnClickListener {

            // -- CHECK TITLE NOT BLANK --
            if (title.text.isBlank()){
                Toast.makeText(this@MainActivity2, "Enter a Title", Toast.LENGTH_SHORT).show()
                title.requestFocus()

            // -- CHECK DATE NOT BLANK --
            } else if (dateWatched.text.isBlank()) {
                Toast.makeText(this@MainActivity2, "Enter a Date", Toast.LENGTH_SHORT).show()
                dateWatched.requestFocus()

            // -- CHECK IF DATE IS 'MM-DD-YYYY' FORMAT --
            } else if (!dateWatched.text.toString().matches(datePattern)) {
                Toast.makeText(this@MainActivity2, "Invalid Date Format", Toast.LENGTH_SHORT).show()
                dateWatched.requestFocus()

            // -- ADD TO LISTVIEW IF ALL REQUIRED FIELDS ARE FILLED OUT --
            } else{

                // -- SET USER INPUTS TO VARS --
                var dateString = dateWatched.text.toString()
                val formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy")
                var date = LocalDate.parse(dateString, formatter)
                var ratingFloat = rating.rating
                var spinnerChoice = movieOrTv.selectedItemPosition

                // -- SPINNER CHOICE --
                movieOrTVChoice = when (spinnerChoice){
                    0 -> "Movie"
                    1 -> "TV Show"
                    else -> "Movie"
                }

                // -- MAKE NEW LIST ITEM A CLASS ITEM --
                var newListItem = listItem(title = title.text.toString(), date, ratingFloat, notes.text.toString())
                //completeList += newListItem

                if (!arrayOfListItemClass.contains(newListItem)){
                    arrayOfListItemClass += newListItem
                }


                Toast.makeText(this@MainActivity2, "${newListItem.title} has been added to your list!", Toast.LENGTH_LONG).show()

                // -- GO BACK TO LISTVIEW --
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }


        }







    }
}