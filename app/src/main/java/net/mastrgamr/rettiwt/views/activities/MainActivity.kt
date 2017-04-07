package net.mastrgamr.rettiwt.views.activities

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import net.mastrgamr.rettiwt.R
import net.mastrgamr.rettiwt.views.fragments.BlankFragment
import net.mastrgamr.rettiwt.views.fragments.MainFragment


class MainActivity : AppCompatActivity(), MainFragment.OnFragmentInteractionListener {

    private val TAG: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        //initial fragment replacement
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /* INNER INTERFACES */
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, MainFragment())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, BlankFragment())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}
