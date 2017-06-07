package net.mastrgamr.rettiwt.viewmodels

import android.databinding.ObservableInt
import android.util.Log
import android.view.View
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterCore
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.models.Tweet

/**
 * Project: Rettiwt
 * Written by: mastrgamr
 * Date: 3/31/17
 */

class MainFragmentViewModel(var timelineRefreshListener: TimelineRefreshListener) {

    private val TAG = javaClass.simpleName

    var isLoading: ObservableInt = ObservableInt(View.VISIBLE)
    var username = "Loading."

    init {
        username = TwitterCore.getInstance().sessionManager.activeSession.userName //TODO -- remove soon
    }

    fun getTweets() {
        TwitterCore.getInstance().apiClient.statusesService.homeTimeline(10, null, null, false, true, false, false)
                .enqueue(object : Callback<List<Tweet>>() {
                    override fun failure(exception: TwitterException?) {
                        Log.d(TAG, "FAILURE")
                        Log.d(TAG, exception!!.message.toString())
                    }
                    override fun success(result: Result<List<Tweet>>?) {
                        timelineRefreshListener.onTimelineRefresh(result!!.data)
                        isLoading.set(View.INVISIBLE)
                    }
                })
    }

    interface TimelineRefreshListener {
        fun onTimelineRefresh(tweets: List<Tweet>)
    }
}