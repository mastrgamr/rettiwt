package net.mastrgamr.rettiwt.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.mastrgamr.rettiwt.R

/**
 * Project: rettiwt
 * Written by: mastrgamr
 * Date: 6/3/17
 */

class TimelineAdapter(val items: ArrayList<String>) : RecyclerView.Adapter<TimelineAdapter.ViewHolder>() {

    val TAG = javaClass.simpleName

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder!!.text = items[position]
        val textView = holder!!.view.findViewById(R.id.text) as TextView
        textView.text = items[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TimelineAdapter.ViewHolder {
        // create a new view
        val v = LayoutInflater.from(parent!!.context).inflate(R.layout.timeline_item, parent, false)
//        val textView = v.findViewById(R.id.text) as TextView
        // set the view's size, margins, paddings and layout parameters
        val vh: ViewHolder = ViewHolder(v)
        return vh
    }

    override fun getItemCount(): Int {
        return items.size
    }
}