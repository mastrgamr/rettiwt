package net.mastrgamr.rettiwt.views.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import net.mastrgamr.rettiwt.R
import net.mastrgamr.rettiwt.adapters.NotificationsAdapter
import net.mastrgamr.rettiwt.databinding.ActivityNotificationsBinding
import net.mastrgamr.rettiwt.viewmodels.NotificationsActivityViewModel

class NotificationsActivity : AppCompatActivity(), NotificationsActivityViewModel.NotificationRefreshListener {

    private var binding: ActivityNotificationsBinding? = null
    // reference to ViewModel class contents
    private var notifActivityVM: NotificationsActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout and attach the ViewModel for this activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notifications)

        notifActivityVM = NotificationsActivityViewModel(this)
        binding!!.vm = notifActivityVM

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding!!.notificationRecview.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@NotificationsActivity)
            // specify an adapter
            val dummyNotifs = ArrayList<String>()
            (1..50).mapTo(dummyNotifs, {"Notification #" + it})
            adapter = NotificationsAdapter(dummyNotifs)
        }
    }

    override fun onNotificationRefresh(notifications: List<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
