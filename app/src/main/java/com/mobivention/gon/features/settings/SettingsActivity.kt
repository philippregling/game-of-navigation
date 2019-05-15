package com.mobivention.gon.features.settings

import android.os.Bundle
import com.mobivention.gon.extensions.replaceFragment
import com.mobivention.gon.features.BaseActivity
import com.mobivention.myapplication.R


class SettingsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        replaceFragment(SettingsFragment())
    }

}