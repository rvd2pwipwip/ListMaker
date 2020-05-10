package com.raywenderlich.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//extend RecyclerView.Adapter and tell it to use the TodoListViewHolder object type
class TodoListAdapter(private val lists: ArrayList<TaskList>, private val clickListener: TodoListClickListener) : RecyclerView.Adapter<TodoListViewHolder>() {

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

    interface TodoListClickListener {
        fun listItemClicked(list: TaskList)
    }

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
        //access view holder's item view and set onClick listener...
        holder.itemView.setOnClickListener {
            //...with constructor's listener that calls listItemClicked
            //and passes the current clicked list
            clickListener.listItemClicked(lists[position])
        }
    }

    fun addList(list: TaskList) {
        lists.add(list)
        //tell recycler view about new list insertion
        notifyItemInserted(lists.size - 1)
    }

}