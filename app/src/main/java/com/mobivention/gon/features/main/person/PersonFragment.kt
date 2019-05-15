package com.mobivention.gon.features.main.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobivention.gon.features.BaseFragment
import com.mobivention.gon.features.main.HouseRepository
import com.mobivention.myapplication.R
import kotlinx.android.synthetic.main.fragment_person.*

class PersonFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar("Jaime Lannister", true)
        initPerson()
    }

    private fun initPerson() {
        val person = HouseRepository.getPersonForHouse("Jaime", "Lannister")
        person?.let {
            person_picture?.setImageResource(it.imageRes)
            person_given_name?.text = it.givenName
            person_surname?.text = it.surname
        }
    }

}