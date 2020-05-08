package com.raywenderlich.listmaker

import android.content.Context
import androidx.preference.PreferenceManager

class ListDataManager(private val context: Context) {

    //write data
    fun saveList(list: TaskList) {
        //access android preference manager's edit mode
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context).edit()
        //add list
        sharedPrefs.putStringSet(list.name, list.tasks.toHashSet())
        //save
        sharedPrefs.apply()
    }

    //read data
    fun readLists(): ArrayList<TaskList> {
        //access android preference manager
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        //access shared preferences content (map of key/value pairs)
        val contents = sharedPrefs.all
        //create a list to hold task lists
        val taskLists = ArrayList<TaskList>()
        //loop through keys
        for (taskList in contents) {
            //get saved hash set and convert it to an array list
            val taskItems = ArrayList(taskList.value as HashSet<String>)
            //create a task list from converted hash set
            val list = TaskList(taskList.key, taskItems)
            //add the list to the array
            taskLists.add(list)
        }
        return taskLists
    }
}