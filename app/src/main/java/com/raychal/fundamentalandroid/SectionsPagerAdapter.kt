package com.raychal.fundamentalandroid

import android.os.Bundle
import android.provider.Settings.Global.putInt
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity)  {

    var appName: String = ""

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        /**
         * simple Tab Layout
         */
//        var fragment: Fragment? = null
//        when (position) {
//            0 -> fragment = HomeFragment()
//            1 -> fragment = ProfileFragment()
//        }
//        return fragment as Fragment
        /**
         * Tab Layout with one fragment
         */
        val fragment = HomeFragment()
        fragment.arguments = Bundle().apply {
            putInt(HomeFragment.ARG_SECTION_NUMBER, position + 1)
            putString(HomeFragment.ARG_NAME, appName)
        }
        return fragment
    }
}