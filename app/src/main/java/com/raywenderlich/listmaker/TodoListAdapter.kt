package com.raywenderlich.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//extend RecyclerView.Adapter and tell it to use the TodoListViewHolder object type
class TodoListAdapter(val lists: ArrayList<TaskList>) : RecyclerView.Adapter<TodoListViewHolder>() {

    //<editor-fold desc="Hardcoded fake data">
    //    private var todoLists = mutableListOf("Android Development", "House Work", "Errands", "Shopping")

//    fun addNewItem() {
//        //message
//        todoLists.add("Todo List ${todoLists.size + 1}")
//        //send data update to recycler view
//        notifyDataSetChanged()
//    }

//    fun addNewItem(listName: String = "") {
//        if (listName.isEmpty()) {
//            todoLists.add("Todo List ${todoLists.size + 1}")
//        } else {
//            todoLists.add(listName)
//        }
//        //send data update to recycler view
//        notifyDataSetChanged()
//    }
    //</editor-fold>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_view_holder, parent, false)
        return TodoListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.listPositionTextView.text = (position + 1).toString()
        holder.listTitleTextView.text = lists[position].name
    }

    fun addList(list: TaskList) {
        lists.add(list)
        //tell recycler view about new list insertion
        notifyItemInserted(lists.size - 1)
    }

}