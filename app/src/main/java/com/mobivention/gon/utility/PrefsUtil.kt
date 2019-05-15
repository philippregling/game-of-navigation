package com.mobivention.gon.utility

import android.content.Context
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.mobivention.gon.model.House

object PrefsUtil {

    private val INACTIVE_HOUSES = "INACTIVE_HOUSES"

    fun getInactiveHouses(context: Context): Set<String> {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getStringSet(INACTIVE_HOUSES, emptySet()) ?: emptySet()
    }

    fun addInactiveHouse(context: Context, house: House) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val inactiveHouses = getInactiveHouses(context)
        inactiveHouses.toMutableSet().add(house.name)
        prefs.edit { putStringSet(INACTIVE_HOUSES, inactiveHouses) }
    }

    fun removeInactiveHouse(context: Context, house: House) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val inactiveHouses = getInactiveHouses(context)
        inactiveHouses.toMutableSet().remove(house.name)
        prefs.edit { putStringSet(INACTIVE_HOUSES, inactiveHouses) }
    }



}