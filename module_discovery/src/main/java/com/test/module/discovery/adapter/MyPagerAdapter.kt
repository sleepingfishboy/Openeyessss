package com.test.module.discovery.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.test.module.discovery.fragment.MonthFragment
import com.test.module.discovery.fragment.TotalFragment
import com.test.module.discovery.fragment.WeekFragment

/**
 *作者：sleepingfishboy
 *时间：2023/7/18

 */
class MyPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WeekFragment()
            1 -> MonthFragment()
            2 -> TotalFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

}