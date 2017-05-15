package net.mastrgamr.rettiwt.viewmodels

import android.content.Context
import android.util.Log

/**
 * Project: rettiwt
 * Written by: mastrgamr
 * Date: 5/14/17
 */
class NotificationsActivityViewModel(private var c: Context) {

    private val TAG = javaClass.simpleName

    private var text = "Loading Your Notifications."

    init {
        Log.d(TAG, "Loading updates.")
    }

    fun getText(): String {
        return this.text
    }
}