package net.mastrgamr.rettiwt.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import net.mastrgamr.rettiwt.Constants
import net.mastrgamr.rettiwt.views.fragments.BlankFragment2
import net.mastrgamr.rettiwt.views.fragments.MainFragment
import net.mastrgamr.rettiwt.views.fragments.NotificationFragment

/**
 * Project: Rettiwt
 * Written by: mastrgamr
 * Date: 4/7/17
 */

class MainPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private val NUM_ITEMS = 3

    override fun getItem(position: Int): Fragment? {
        when (position) {
            Constants.PAGE_ONE -> { // Fragment # 0 - This will show FirstFragment
                return MainFragment.newInstance("Page # 1")
            }
            Constants.PAGE_TWO -> { // Fragment # 0 - This will show FirstFragment different title
                return NotificationFragment.newInstance("Page # 2")
            }
            Constants.PAGE_THREE -> { // Fragment # 1 - This will show SecondFragment
                return BlankFragment2.newInstance("Page # 3")
            }
        }
        return null
    }

    override fun getCount(): Int {
        return NUM_ITEMS
    }



}
