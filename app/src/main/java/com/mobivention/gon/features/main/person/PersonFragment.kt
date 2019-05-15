package com.mobivention.gon.features.main.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.mobivention.gon.features.BaseFragment
import com.mobivention.gon.features.main.HouseRepository
import com.mobivention.gon.utility.NotificationUtil
import com.mobivention.myapplication.R
import kotlinx.android.synthetic.main.fragment_person.*

class PersonFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: PersonFragmentArgs by navArgs()
        initPerson(safeArgs.houseName, safeArgs.personName)
    }

    private fun initPerson(houseName: String, personName: String) {
        val person = HouseRepository.getPersonForHouse(personName, houseName)
        person?.let {
            setToolbar(person.givenName, true)
            person_picture?.setImageResource(it.imageRes)
            person_given_name?.text = it.givenName
            person_surname?.text = it.surname
        }
        context?.let { NotificationUtil.sendNotification(it) }
    }

}