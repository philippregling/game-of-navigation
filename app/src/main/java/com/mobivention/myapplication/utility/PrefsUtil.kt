package com.mobivention.myapplication.utility

import android.content.Context
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.mobivention.myapplication.model.House

object PrefsUtil {

    private val INACTIVE_HOUSES = "INACTIVE_HOUSES"

    fun getInactiveHouses(context: Context) : List<String>{
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getStringSet(INACTIVE_HOUSES, emptySet())?.toList() ?: emptyList()
    }

    fun saveInactiveHouses(context: Context, inactiveHouses : List<House>){
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit { putStringSet(INACTIVE_HOUSES, inactiveHouses.map { it.name }.toSet()) }
    }

}