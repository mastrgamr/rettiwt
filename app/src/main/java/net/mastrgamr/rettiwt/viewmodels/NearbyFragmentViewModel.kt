package net.mastrgamr.rettiwt.viewmodels

import android.content.Context
import android.util.Log

/**
 * Project: rettiwt
 * Written by: mastrgamr
 * Date: 4/8/17
 */
class NearbyFragmentViewModel(private var c: Context) {

    private val TAG = javaClass.simpleName

    private var text = "Loading Tweets Nearby."

    init {
        Log.d(TAG, "Loading Nearby Tweets.")
    }

    fun getText(): String {
        return this.text
    }
}