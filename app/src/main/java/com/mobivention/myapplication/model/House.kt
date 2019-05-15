package com.mobivention.myapplication.model

import androidx.annotation.DrawableRes

class House(val name: String,
            val motto : String,
            var members : List<Person> = emptyList(),
            @DrawableRes val imageRes : Int)