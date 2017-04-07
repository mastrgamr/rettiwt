package net.mastrgamr.rettiwt.viewmodels

import android.content.Context
import com.twitter.sdk.android.Twitter
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.models.Tweet
import com.twitter.sdk.android.tweetui.TimelineResult
import com.twitter.sdk.android.tweetui.UserTimeline

/**
 * Project: Rettiwt
 * Written by: mastrgamr
 * Date: 3/31/17
 */

class MainFragmentViewModel(private var c: Context) {

    private val TAG = javaClass.simpleName

    private var username = "Loading."

    init {
        val userTimeline = UserTimeline.Builder().screenName("mastrgamr").build()
        userTimeline.next(779334317881323520L, object : Callback<TimelineResult<Tweet>>() {
            override fun success(result: Result<TimelineResult<Tweet>>?) {
//                Log.d(TAG, result!!.data.items.toString())
                for(tweet: Tweet in result!!.data.items){
                    println(tweet.text)
                }
            }

            override fun failure(exception: TwitterException?) {
                println("FAILURE!")
            }

        })
        username = Twitter.getSessionManager().activeSession.userName
    }

    fun getUsername(): String {
        return this.username
    }
}