package com.raywenderlich.listmaker

import android.app.AlertDialog
import android.os.Bundle
import android.text.InputType
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //access recycler view
    private lateinit var todoListRecyclerView: RecyclerView
    val listDataManager = ListDataManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //get lists from list data manager
        val lists = listDataManager.readLists()

        //reference to recyclerView in content_main.xml
        todoListRecyclerView = findViewById(R.id.lists_recyclerview)
        //tell recyclerView which layout to use for its items
        todoListRecyclerView.layoutManager = LinearLayoutManager(this)
        //assign adapter to recyclerView and pass in the lists
        todoListRecyclerView.adapter = TodoListAdapter(lists)

//        //default toast code
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

        fab.setOnClickListener { _ ->
//            //get the recycler view adapter and cast as own adapter
//            val adapter = todoListRecyclerView.adapter as TodoListAdapter
//            adapter.addNewItem()
            showCreateTodoListDialog()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showCreateTodoListDialog() {
        val dialogTitle = getString(R.string.name_of_list_prompt)
        val positiveButtonTitle = getString(R.string.create_list)
        val myDialog = AlertDialog.Builder(this)
        val todoTitleEditText = EditText(this)
        todoTitleEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
        myDialog.setTitle(dialogTitle)
        myDialog.setView(todoTitleEditText)
        myDialog.setPositiveButton(positiveButtonTitle) { dialog, _ ->
            val adapter = todoListRecyclerView.adapter as TodoListAdapter
            //create empty task list and pass the editText value as the title
            val list = TaskList(todoTitleEditText.text.toString())
            //save the list
            listDataManager.saveList(list)
            //update recycler view with new list of task lists
//            adapter.addNewItem(todoTitleEditText.text.toString())
            adapter.addList(list)
            dialog.dismiss()
        }
        myDialog.create().show()
    }
}
























