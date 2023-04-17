package com.example.mad_105_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
//import android.R

var things = arrayOf("")
var arrayOfListItemClass = arrayOf<listItem>()



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var itemOne = listItem("Movie 1", date = LocalDate.parse("10-01-2023", formatter), rating = 5.0F, review =  "Good")
        //var itemTwo = listItem("movie 2", null, 3.0F, "not bad")
        arrayOfListItemClass += itemOne
        arrayOfListItemClass += itemTwo


        //  ---- THE 'ADD' BUTTON ----
        val addButton = findViewById<Button>(R.id.addItemButton)
        addButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }



        // ---- LIST VIEW ITEMS ----
//        for (i in completeList){
//
//            things += i.title + " Rating: " + i.rating + "/5"
            //val layoutParams = LinearLayout.LayoutParams(
            //    ViewGroup.LayoutParams.MATCH_PARENT,
            //    ViewGroup.LayoutParams.WRAP_CONTENT
            //)
            //rBar.layoutParams = layoutParams
//            val rBar = findViewById<RatingBar>(R.id.watchListRatingBar)
//            rBar.stepSize = 0.5.toFloat()
//            rBar.numStars = 5
//
//            rBar.rating = i.rating
//            things += rBar

//        }

        //println("--------hello-----------")
        //println(itemOne.title)
        //itemOne.printListItem()

        // ------ FILL LISTVIEW ANOTHER WAY -------

        // val adapter = object : ArrayAdapter<String> (this, R.layout.list_item, things)


        // ------- WORKING LISTVIEW BUT NOT PRETTY --------
//        val listView = findViewById<ListView>(R.id.watchList)
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, things)
//        listView.adapter = adapter

        // --------------- another try ---------------------

        val listView = findViewById<ListView>(R.id.watchList)
        val adapter = MyListviewAdapter(this, R.layout.list_item, arrayOfListItemClass.toMutableList())
        listView.adapter = adapter


        // ---- LIST ITEM ON CLICK ----
        listView.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity, "This will go to a full details page... eventually", Toast.LENGTH_LONG).show()
            }
        }

    }

//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View{
//        val view = convertView ?:
//        LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
//        val title = view.findViewById<TextView>(R.id.listItemTitle)
//        val rating = view.findViewById<RatingBar>(R.id.listItemRatingBar)
//
//        title.text = getItem(things.title.position)
//
//    }

}



private operator fun <T> Array<T>.plusAssign(rBar: RatingBar?) {

}
