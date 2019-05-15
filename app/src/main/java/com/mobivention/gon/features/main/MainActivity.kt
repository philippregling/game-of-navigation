package com.mobivention.gon.features.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mobivention.gon.extensions.replaceFragment
import com.mobivention.gon.features.BaseActivity
import com.mobivention.gon.features.main.houses.HousesFragment
import com.mobivention.gon.features.main.more.MoreFragment
import com.mobivention.myapplication.R

class MainActivity : BaseActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_houses -> {
                replaceFragment(HousesFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_more -> {
                replaceFragment(MoreFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navView.selectedItemId = R.id.navigation_houses
    }


}
