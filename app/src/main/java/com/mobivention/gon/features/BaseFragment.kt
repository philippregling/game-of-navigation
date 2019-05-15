package com.mobivention.gon.features

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mobivention.gon.extensions.setToolbar

open class BaseFragment : Fragment() {


    fun setToolbar(title: String, showBack: Boolean) {
        (activity as AppCompatActivity?)?.setToolbar(title, showBack)
    }
}