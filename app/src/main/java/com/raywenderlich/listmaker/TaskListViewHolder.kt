package com.raywenderlich.listmaker

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//add primary constructor that will receive a view and pass it to its super constructor
class TaskListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    //get reference to textView
    var taskTextView = itemView.findViewById<TextView>(R.id.textView_task) as TextView
}