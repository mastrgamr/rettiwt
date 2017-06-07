package net.mastrgamr.rettiwt.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.twitter.sdk.android.core.models.Tweet
import net.mastrgamr.rettiwt.R
import net.mastrgamr.rettiwt.databinding.TimelineItemBinding
import net.mastrgamr.rettiwt.viewmodels.TimelineItemViewModel


/**
 * Project: rettiwt
 * Written by: mastrgamr
 * Date: 6/3/17
 */

class TimelineAdapter(var items: List<Tweet>) : RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder>() {

    val TAG = javaClass.simpleName

    constructor() : this(emptyList())

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class TimelineViewHolder(var view: TimelineItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onBindViewHolder(holder: TimelineViewHolder?, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder!!.view.vm.tweet.set(items[position].text)
        holder.view.vm.user.set(items[position].user.screenName)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TimelineAdapter.TimelineViewHolder {
        // create a new view
        val inflater = parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding: TimelineItemBinding = DataBindingUtil.inflate(inflater, R.layout.timeline_item, parent, false)
        binding.vm = TimelineItemViewModel()

        return TimelineViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(tweets: List<Tweet>){
        items = emptyList()
        items = tweets
        notifyDataSetChanged()
    }
}