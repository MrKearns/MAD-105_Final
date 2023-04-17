package com.example.mad_105_final

import android.content.Context
import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RatingBar
import android.widget.TextView



class MyListviewAdapter(context: Context?, resource: Int, objects: MutableList<listItem>?) : ArrayAdapter<listItem?>(context!!, resource,
    objects!! as List<listItem?>
) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }
        val item = getItem(position)
        val textView = convertView!!.findViewById<TextView>(R.id.listItemTitle)
        val ratingBar = convertView!!.findViewById<RatingBar>(R.id.listItemRatingBar)
        textView.text = item!!.title
        ratingBar.rating = item!!.rating

        ratingBar.isEnabled = false

        return convertView
    }
}






//    class MyListviewAdapter(context: Context?, resource: Array<listItem>, objects: MutableList<listItem>?) : ArrayAdapter<listItem>(context!!, resource, objects!!) {
//        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//            var convertView = convertView
//            if(convertView == null) {
//                convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
//            }
//
//            val item = getItem(position)
//            val textView = convertView!!.findViewById<TextView>(R.id.listItemTitle)
//            val ratingBar = convertView!!.findViewById<RatingBar>(R.id.listItemRatingBar)
//            textView.text = item!!.title
//            ratingBar.rating = item!!.rating
//
//            return convertView
//
//        }
//    }



//class MyListviewAdapter(context: Context, private val arrayOfListItemClass: Array<String>) : ArrayAdapter<String>(context, R.layout.list_item, completeList) {
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//
//        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
//
//        val title = view.findViewById<TextView>(R.id.listItemTitle)
//        val ratingRar = view.findViewById<RatingBar>(R.id.listItemRatingBar)
//
//        title.text = CompleteArray.title[position]
//        title.text = getItem(position)
//        val rating = 3.5F
//        ratingRar.rating = rating
//
//        return view
//    }
//}