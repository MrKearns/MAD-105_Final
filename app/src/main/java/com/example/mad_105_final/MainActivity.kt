package com.example.mad_105_final

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
//import android.R

var things = arrayOf("")
var arrayOfListItemClass = arrayOf<listItem>()



class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        print("---THE APP STARTED---")

        //var summaryTitle = findViewById<TextView>(R.id.summaryTitle)
        //var summaryDate = findViewById<TextView>(R.id.summaryDate)

        //var itemOne = listItem("Movie 1", date = LocalDate.parse("10-01-2023", formatter), rating = 5.0F, review =  "Good")
        //var itemTwo = listItem("movie 2", null, 3.0F, "not bad")
        //arrayOfListItemClass += itemOne
        //arrayOfListItemClass += itemTwo


        //  ---- THE 'ADD' BUTTON ----
        val addButton = findViewById<Button>(R.id.addItemButton)
        addButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        // --------------- LISTVIEW ---------------------
        val listView = findViewById<ListView>(R.id.watchList)
        val adapter = MyListviewAdapter(this, R.layout.list_item, arrayOfListItemClass.toMutableList())
        listView.adapter = adapter


        // ---- LIST ITEM ON CLICK ----
        listView.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {



                val selected = adapter.getItem(p2)
                val title = selected?.title
                val date = selected?.date
                val rating = selected?.rating
                val summary = selected?.review
                val tvMovie = selected?.TvOrMovie

                Toast.makeText(this@MainActivity, "This will go to a full details page... eventually", Toast.LENGTH_LONG).show()


                // -- SET INTENTS FOR SUMMARY SCREEN --
                val intent = Intent(this@MainActivity, MainActivity3::class.java)
                intent.putExtra("title", title.toString())
                intent.putExtra("date", date.toString())
                intent.putExtra("summary", summary.toString())
                intent.putExtra("rating", rating?.toFloat())
                intent.putExtra("tvOrMovie", tvMovie.toString())

                startActivity(intent)
            }
        }

    }

}



private operator fun <T> Array<T>.plusAssign(rBar: RatingBar?) {

}
