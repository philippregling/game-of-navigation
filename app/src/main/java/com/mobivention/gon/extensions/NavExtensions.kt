package com.mobivention.gon.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mobivention.gon.features.BaseFragment
import com.mobivention.myapplication.R

fun AppCompatActivity.replaceFragment(fragment: BaseFragment) {
//    supportFragmentManager
//        .beginTransaction()
//        .replace(R.id.fragment_container, fragment)
//        .commit()
}

fun AppCompatActivity.replaceFragmentAddToBackstack(fragment: BaseFragment) {
//    supportFragmentManager
//        .beginTransaction()
//        .replace(R.id.fragment_container, fragment)
//        .addToBackStack(null)
//        .commit()
}

fun AppCompatActivity.setToolbar(title: String, showBack: Boolean) {
    findViewById<Toolbar>(R.id.toolbar)?.let {
        it.title = title
        setSupportActionBar(it)
        supportActionBar?.setDisplayHomeAsUpEnabled(showBack)
    }

}