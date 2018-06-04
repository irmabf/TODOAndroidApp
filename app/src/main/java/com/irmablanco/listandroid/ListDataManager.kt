package com.irmablanco.listandroid

import android.content.Context
import android.preference.PreferenceManager
import java.util.function.Predicate
import java.util.prefs.PreferenceChangeEvent

class ListDataManager(val context: Context) {
    //Method to save the list
    fun saveList(list: TaskList){
        //I need an instance of SharedPreferences
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()

        sharedPreferences.putStringSet(list.name, list.tasks.toHashSet())
        sharedPreferences.apply()
    }
    fun readList(): ArrayList<TaskList> {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        //Get the contents of my sharedPreferences
        val sharedPreferenceContents = sharedPreferences.all
        val taskList = ArrayList<TaskList>()
        for (preferenceItem in sharedPreferenceContents){
            val itemHashSet = preferenceItem.value as HashSet<String>
            val list = TaskList(preferenceItem.key, ArrayList(itemHashSet))
            taskList.add(list)
        }
        return  taskList

    }
}
