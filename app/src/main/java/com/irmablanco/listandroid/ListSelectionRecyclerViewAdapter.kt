package com.irmablanco.listandroid

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/*
* Our ListSelectionRecyclerViewAdapter extends a RecyclerView.Adapter
* which receives a view holder
* */
class ListSelectionRecyclerViewAdapter: RecyclerView.Adapter<ListSelectionRecylerViewHolder>(){

    /**
     * We create an instance variable to contain our list of TODOs
     * */
    val listTitles = arrayOf("Shopping List", "Chores", "Android Tutorials")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionRecylerViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return listTitles.size
    }

    override fun onBindViewHolder(holder: ListSelectionRecylerViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
