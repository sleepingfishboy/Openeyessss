package com.test.module.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*


class HomeFragment : Fragment() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager2 = view.findViewById(R.id.viewPager)
        viewPager2.isSaveEnabled = false
        tabLayout = view.findViewById(R.id.tabLayout)
        val titleList: List<String> = initPageTitleList()
        val tabLayoutChildViewPager =
            TabLayoutChildViewPager(requireActivity(), initChildFragment())
        viewPager2.adapter = tabLayoutChildViewPager
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = titleList[position]
        }.attach()
    }

    private fun initPageTitleList(): List<String> {
        return listOf("推荐", "日报")
    }

    inner class TabLayoutChildViewPager(
        fragmentActivity: FragmentActivity,
        private val fragmentList: kotlin.collections.List<Fragment>
    ) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }

    }

    private fun initChildFragment(): List<Fragment> {
        val recommendFragment = RecommendFragment()
        val dailyFragment = DailyFragment()
        return listOf(recommendFragment, dailyFragment)
    }
}