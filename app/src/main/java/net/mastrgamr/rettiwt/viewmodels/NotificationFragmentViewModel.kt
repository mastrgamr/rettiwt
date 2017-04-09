package net.mastrgamr.rettiwt.viewmodels

import android.content.Context
import android.util.Log

/**
 * Project: rettiwt
 * Written by: mastrgamr
 * Date: 4/8/17
 */
class NotificationFragmentViewModel(private var c: Context) {

    private val TAG = javaClass.simpleName

    private var text = "Loading Notifications."

    init {
        Log.d(TAG, "Loading Notifications.")
    }

    fun getText(): String {
        return this.text
    }
}