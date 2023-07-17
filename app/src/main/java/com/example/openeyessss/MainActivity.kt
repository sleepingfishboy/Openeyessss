package com.example.openeyessss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.test.module.discovery.DiscoveryFragment
import com.test.module.home.HomeFragment
import com.test.module.square.SquareFragment
import com.test.module.user.UserFragment

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var fragmentContainerView: FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView=findViewById(R.id.bottom_navigation_view)
        fragmentContainerView=findViewById(R.id.container_view)

        val fragmentMap:MutableMap<Int, Fragment> =HashMap()
        val homeFragment= HomeFragment()
        val squareFragment=SquareFragment()
        val discoveryFragment=DiscoveryFragment()
        val userFragment=UserFragment()
        fragmentMap[R.id.home]=homeFragment
        fragmentMap[R.id.discovery]=discoveryFragment
        fragmentMap[R.id.square]=squareFragment
        fragmentMap[R.id.user]=userFragment

        bottomNavigationView.setOnItemSelectedListener{item->
            when(item.itemId){
                R.id.home->supportFragmentManager.beginTransaction().replace(
                    R.id.container_view,fragmentMap[R.id.home]!!).commit()
                R.id.square->supportFragmentManager.beginTransaction().replace(
                    R.id.container_view,fragmentMap[R.id.square]!!).commit()
                R.id.discovery->supportFragmentManager.beginTransaction().replace(
                    R.id.container_view,fragmentMap[R.id.discovery]!!).commit()
                R.id.user->supportFragmentManager.beginTransaction().replace(
                    R.id.container_view,fragmentMap[R.id.user]!!).commit()
            }
            true
        }
    }
}