package net.mastrgamr.rettiwt.views.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import net.mastrgamr.rettiwt.R
import net.mastrgamr.rettiwt.views.fragments.TimelineFragment
import net.mastrgamr.rettiwt.views.fragments.NearbyFragment
import net.mastrgamr.rettiwt.views.fragments.YouFragment

class MainActivity : AppCompatActivity(){

    private val TAG: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        val navigation = findViewById(R.id.navigation) as BottomNavigationView

        setSupportActionBar(toolbar)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, TimelineFragment.newInstance("Oi"))
                .commit()
    }

    /* INNER INTERFACES */
    //TODO -- implement some sort o stack-tracker to highlight the correct nav item onBackPressed()
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction()
                        .add(R.id.main_container, TimelineFragment.newInstance("Oi"))
                        .addToBackStack(null)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_nearby -> {
                supportFragmentManager.beginTransaction()
                        .add(R.id.main_container, NearbyFragment.newInstance("Oi"))
                        .addToBackStack(null)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_you -> {
                supportFragmentManager.beginTransaction()
                        .add(R.id.main_container, YouFragment.newInstance("Oi"))
                        .addToBackStack(null)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    // Keeping this MVC-like, too simple to break out to a ViewModel
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.itemId) {
            R.id.actions_notif -> {
                Log.d(TAG, "Pushing Activity")
                startActivity(Intent(this, NotificationsActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
