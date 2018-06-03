package com.irmablanco.listandroid

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/*
* Our ListSelectionRecyclerViewAdapter extends a RecyclerView.Adapter
* which receives a view holder
* */
class ListSelectionRecyclerViewAdapter: RecyclerView.Adapter<ListSelectionRecyclerViewHolder>(){


    val listTitles = arrayOf("Shopping List", "Chores", "Android Tutorials")
    override fun getItemCount(): Int {
        return listTitles.size
    }

    override fun onBindViewHolder(holder: ListSelectionRecyclerViewHolder, position: Int) {
        //1. Check if we have a holder (cell)
        if (holder != null){
            holder.listPosition.text = (position + 1).toString()
            holder.listTitle.text = listTitles[position]
        }
    }
    /**onCreateViewHolder provides a layout for us to use for each piece of data
     * and that layout is create for each row
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionRecyclerViewHolder {
        //We create an instance of our list_selection_view_holder layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_selection_view_holder, parent, false)
        return ListSelectionRecyclerViewHolder(view)
    }



}
