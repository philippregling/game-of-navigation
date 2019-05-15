package com.mobivention.gon.model

import androidx.annotation.DrawableRes

data class Person(val house: House,
                  val givenName : String,
                  val surname :String,
                  @DrawableRes val imageRes : Int)