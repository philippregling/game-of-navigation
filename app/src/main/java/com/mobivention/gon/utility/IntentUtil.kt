package com.mobivention.gon.utility

import android.app.Activity
import android.content.Intent
import com.mobivention.gon.features.settings.SettingsActivity

object IntentUtil {


    fun openSettings(activity: Activity) {
        activity.startActivity(Intent(activity, SettingsActivity::class.java))
    }

}