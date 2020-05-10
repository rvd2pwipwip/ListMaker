package com.raywenderlich.listmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailActivity : AppCompatActivity() {

    lateinit var list: TaskList
    lateinit var taskListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //get the list from the MainActivity's intent
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY) as TaskList
        title = list.name

        //reference to recyclerView in activity_detail.xml
        taskListRecyclerView = findViewById(R.id.task_list_recyclerview)
        //tell recyclerView which layout to use for its items
        taskListRecyclerView.layoutManager = LinearLayoutManager(this)
        //assign adapter to recyclerView and pass in the list
        taskListRecyclerView.adapter = TaskListAdapter(list)
    }
}
