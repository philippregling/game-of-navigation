package com.mobivention.myapplication.utility

import com.mobivention.myapplication.R
import com.mobivention.myapplication.model.House
import com.mobivention.myapplication.model.Person

object TestDataUtil {


    fun initAllHousesAndPeople() : List<House> {
        val allHouses = mutableListOf<House>()
        val lannister = House(name = "Lannister",
            motto = "Hear me roar!",
            imageRes = R.drawable.house_lannister)
        val lannister_members = listOf(Person(givenName = "Jamie",
            surname = "Lannister",
            house = lannister,
            imageRes = R.drawable.jaime_lannister),
            Person(givenName = "Cersei",
                surname = "Lannister",
                house = lannister,
                imageRes = R.drawable.cersei_lannister))
        lannister.members = lannister_members
        val stark = House(name = "Stark",
            motto = "Winter is coming!",
            imageRes = R.drawable.house_stark)
        allHouses.add(lannister)
        allHouses.add(stark)
        return allHouses
    }


}