package com.example.mad_105_final

import java.time.LocalDate
import java.time.format.DateTimeFormatter


var formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy")
//var completeList = arrayOf<listItem>()

class listItem(var title: String, var date: LocalDate?, var rating: Float, var review: String?, var TvOrMovie: String?) {

    fun printListItem() {
        println(title)
        println(date)
        println(rating)
        println(review)
    }

}

var itemOne = listItem("Movie 1", date = LocalDate.parse("10-01-2023", formatter), rating = 5.0F, review =  "Good", "TV Show")
var itemTwo = listItem("movie 2", null, 3.0F, "not bad", "Movie")


var completeList = arrayOf<listItem>(itemOne, itemTwo)

