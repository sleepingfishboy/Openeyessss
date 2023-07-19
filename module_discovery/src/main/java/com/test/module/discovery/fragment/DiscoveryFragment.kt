package com.test.module.discovery.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.test.module.discovery.R
import com.test.module.discovery.adapter.MyPagerAdapter


class DiscoveryFragment : Fragment() {

    private lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.view_pager)

        // Create a new instance of MyPagerAdapter
        val pagerAdapter = MyPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Set tab's text
            when (position) {
                0 -> tab.text = "周排行"
                1 -> tab.text = "月排行"
                2 -> tab.text = "总排行"
            }
        }.attach()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentToRemove = getChildFragmentManager().findFragmentById(R.id.container)
        if (fragmentToRemove != null) {
            childFragmentManager.beginTransaction().remove(fragmentToRemove).commit()
        }


        return inflater.inflate(R.layout.fragment_discovery, container, false)
    }
}