package com.test.module.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeMainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var fragmentContainerView: FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_main)
        bottomNavigationView=findViewById(R.id.bottom_navigation_view)
        fragmentContainerView=findViewById(R.id.container_view)

        val fragmentMap:MutableMap<Int,Fragment> =HashMap()
        val homeFragment= HomeFragment()
        fragmentMap[R.id.home]=homeFragment

        bottomNavigationView.setOnItemSelectedListener{item->
            when(item.itemId){
                R.id.home->supportFragmentManager.beginTransaction().replace(R.id.container_view,fragmentMap[R.id.home]!!).commit()
                R.id.square->supportFragmentManager.beginTransaction().replace(R.id.container_view,fragmentMap[R.id.square]!!).commit()
            }
            true
        }
    }
}