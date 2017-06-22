package net.mastrgamr.rettiwt.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import net.mastrgamr.rettiwt.R
import net.mastrgamr.rettiwt.databinding.NotificationItemBinding
import net.mastrgamr.rettiwt.viewmodels.NotificationItemViewModel

/**
 * Project: rettiwt
 * Created: Stuart Smith
 * Date: 6/7/2017.
 */

class NotificationsAdapter(var items: List<String>) : RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder>() {

    val TAG = javaClass.simpleName

    constructor() : this(emptyList())

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class NotificationsViewHolder(var view: NotificationItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NotificationsViewHolder {
        val inflater = parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding: NotificationItemBinding = DataBindingUtil.inflate(inflater, R.layout.notification_item, parent, false)
        binding.vm = NotificationItemViewModel()

        return NotificationsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationsViewHolder?, position: Int) {
        holder!!.view.vm.notification.set(items[position])
    }
}
