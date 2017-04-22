package net.mastrgamr.rettiwt.views.activities

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v4.view.ViewPager.OnPageChangeListener
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import net.mastrgamr.rettiwt.Constants
import net.mastrgamr.rettiwt.R
import net.mastrgamr.rettiwt.adapters.MainPagerAdapter
import net.mastrgamr.rettiwt.views.fragments.MainFragment


class MainActivity : AppCompatActivity(), MainFragment.OnFragmentInteractionListener, OnPageChangeListener {

    private val TAG: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        val pager = findViewById(R.id.pager) as ViewPager
        val pagerAdapter: FragmentPagerAdapter = MainPagerAdapter(supportFragmentManager)

        pager.addOnPageChangeListener(this)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        pager.adapter = pagerAdapter
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /* INNER INTERFACES */
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                pager.currentItem = Constants.PAGE_ONE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                pager.currentItem = Constants.PAGE_TWO
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                pager.currentItem = Constants.PAGE_THREE
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onPageScrollStateChanged(state: Int) {
//        Log.d(TAG, "State changed: " + state)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//        Log.d(TAG, "Page scrolled: " + position)
    }

    override fun onPageSelected(position: Int) {
//        Log.d(TAG, "Page selected: " + position)

        when(position) {
            Constants.PAGE_ONE -> {
                navigation.selectedItemId = R.id.navigation_home
            }
            Constants.PAGE_TWO -> {
                navigation.selectedItemId = R.id.navigation_dashboard
            }
            Constants.PAGE_THREE -> {
                navigation.selectedItemId = R.id.navigation_notifications
            }
        }
    }

}
