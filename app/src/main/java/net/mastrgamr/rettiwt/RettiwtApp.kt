package net.mastrgamr.rettiwt

import android.app.Application
import com.twitter.sdk.android.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import es.dmoral.prefs.Prefs
import io.fabric.sdk.android.Fabric

/**
 * Project: Rettiwt
 * Written by: mastrgamr
 * Date: 4/3/17
 */
class RettiwtApp: Application() {

    override fun onCreate() {
        super.onCreate()

        val authConfig = TwitterAuthConfig(resources.getString(R.string.TWITTER_KEY),
                                            resources.getString(R.string.TWITTER_SECRET))
        Fabric.with(this, Twitter(authConfig))
    }
}