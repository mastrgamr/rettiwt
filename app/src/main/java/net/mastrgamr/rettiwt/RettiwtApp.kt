package net.mastrgamr.rettiwt

import android.app.Application
import android.util.Log
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig

/**
 * Project: Rettiwt
 * Written by: mastrgamr
 * Date: 4/3/17
 */

class RettiwtApp: Application() {

    override fun onCreate() {
        super.onCreate()

        val config = TwitterConfig.Builder(this)
                .logger(DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(TwitterAuthConfig(getString(R.string.TWITTER_KEY), getString(R.string.TWITTER_SECRET)))
                .debug(true)
                .build()
        Twitter.initialize(config)
    }
}