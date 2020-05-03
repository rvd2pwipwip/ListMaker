package com.raywenderlich.listmaker

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//add primary constructor that will receive a view and pass it to its super constructor
class TodoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var listPositionTextView = itemView.findViewById<TextView>(R.id.itemNumber)
    var listTitleTextView = itemView.findViewById<TextView>(R.id.itemString)
}