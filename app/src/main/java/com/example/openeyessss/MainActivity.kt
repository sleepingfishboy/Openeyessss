package com.example.openeyessss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController=Navigation.findNavController(this,R.id.nav_host_fragment)
        bottomNavigationView=findViewById(R.id.bottom_navigation_view)
        NavigationUI.setupWithNavController(bottomNavigationView,navController)
    }
}
