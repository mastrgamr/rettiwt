package net.mastrgamr.rettiwt.viewmodels

/**
 * Project: rettiwt
 * Written by: mastrgamr
 * Date: 5/14/17
 */
class NotificationsActivityViewModel(val notificationRefreshListener: NotificationRefreshListener) {

    private val TAG = javaClass.simpleName

    var text = "Loading Your Notifications."

    interface NotificationRefreshListener {
        fun onNotificationRefresh(notifications: List<String>)
    }
}