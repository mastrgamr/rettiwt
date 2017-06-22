package net.mastrgamr.rettiwt.views.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.core.identity.TwitterLoginButton
import es.dmoral.prefs.Prefs
import net.mastrgamr.rettiwt.R

/*
* Documentation: https://docs.fabric.io/android/twitter/log-in-with-twitter.html
*/
class LoginActivity : Activity() {

    private val TAG = javaClass.simpleName

    private var logBtn: TwitterLoginButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //if an access token is defined in the preferences
        //skip the login flow altogether and start the main app
        if(Prefs.with(this).read("access_token").isNotEmpty()){
            Log.d(TAG, "Token found, start Main app.")
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        logBtn = findViewById(R.id.login_button) as TwitterLoginButton
        logBtn!!.callback = object : Callback<TwitterSession>() {
            override fun success(result: Result<TwitterSession>) {
                // Do something with result, which provides a TwitterSession for making API calls
                Log.d(TAG, result.data.userName)

                // Write the tokens to Preferences
                // WARNING: Usually not too safe, but this is an open source app. You know what you signed up for.
                Prefs.with(this@LoginActivity).write("access_token", result.data.authToken.token)
                Prefs.with(this@LoginActivity).write("secret", result.data.authToken.secret)
            }

            override fun failure(exception: TwitterException) { }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Pass the activity result to the login button.
        logBtn!!.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "Result Code: " + resultCode)

        if(resultCode == -1) { //on successful login -- P.S. WTF is the TwitterAPI Enum code for this!?
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        // Example of static Auth Session
//        val session = Twitter.getSessionManager().activeSession
//        val authToken = session.authToken
//        val token = authToken.token
//        val secret = authToken.secret
    }
}
