package net.mastrgamr.rettiwt.viewmodels

import android.content.Context
import android.util.Log
import com.twitter.sdk.android.Twitter
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

class MainFragmentViewModel(private var c: Context) {

    private val TAG = javaClass.simpleName

    private var username = "Loading."

    init {
//        val userTimeline = UserTimeline.Builder().screenName("mastrgamr").build()
//        userTimeline.next(850183841348292608L, object : Callback<TimelineResult<Tweet>>() {
//            override fun success(result: Result<TimelineResult<Tweet>>?) {
////                Log.d(TAG, result!!.data.items.toString())
//                for(tweet: Tweet in result!!.data.items){
//                    println(tweet.text)
//                }
//            }
//
//            override fun failure(exception: TwitterException?) {
//                println("FAILURE!")
//            }
//        })
        username = Twitter.getSessionManager().activeSession.userName
        TwitterCore.getInstance().apiClient.statusesService.homeTimeline(10, null, null, true, true, false, false)
                .enqueue(object : Callback<List<Tweet>>() {
            override fun failure(exception: TwitterException?) {
                Log.d(TAG, "FAILURE")
                Log.d(TAG, exception!!.message.toString())
            }

            override fun success(result: Result<List<Tweet>>?) {
                for(tweet: Tweet in result!!.data){
                    Log.d(TAG, "${tweet.id} - ${tweet.text}")
                }
            }

        })
    }

    fun getUsername(): String {
        return this.username
    }
}