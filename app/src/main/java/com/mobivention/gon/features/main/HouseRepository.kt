package com.mobivention.gon.features.main

import android.content.Context
import com.mobivention.gon.model.House
import com.mobivention.gon.model.Person
import com.mobivention.gon.utility.PrefsUtil
import com.mobivention.gon.utility.TestDataUtil

object HouseRepository {

    val houses = TestDataUtil.initAllHousesAndPeople()

    fun getHouseForName(houseName: String): House? {
        return houses.find { it.name == houseName }
    }

    fun getPersonForHouse(givenName: String, houseName: String): Person? {
        return houses.find { it.name == houseName }?.members?.find { it.givenName == givenName }
    }

    fun getPeopleForHouse(houseName: String): List<Person> {
        return houses.find { it.name == houseName }?.members ?: emptyList()
    }

    fun filterForActiveHouses(context: Context): List<House> {
        val inactiveHouses = PrefsUtil.getInactiveHouses(context)
        return houses.filter { itHouse -> inactiveHouses.find { itHouse.name == it } == null }
    }

    fun isHouseInactive(context: Context, house: House): Boolean {
        val inactiveHouses = PrefsUtil.getInactiveHouses(context)
        return inactiveHouses.contains(house.name)
    }

}