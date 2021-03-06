package com.mobivention.gon.features.main.houses.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobivention.gon.features.BaseFragment
import com.mobivention.gon.features.main.HouseRepository
import com.mobivention.gon.model.Person
import com.mobivention.myapplication.R
import kotlinx.android.synthetic.main.fragment_house_detail.*

class HouseDetailFragment : BaseFragment(),
    HouseDetailAdapter.Listener {

    val adapter: HouseDetailAdapter by lazy { HouseDetailAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_house_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: HouseDetailFragmentArgs by navArgs()
        val houseName = safeArgs.houseName ?: ""
        setToolbar(houseName, true)
        initHouseDetail(houseName)
        initRecyclerView(houseName)
    }

    private fun initHouseDetail(houseName: String) {
        val house = HouseRepository.getHouseForName(houseName)
        house?.let {
            house_detail_picture?.setImageResource(it.imageRes)
            house_detail_name?.text = it.name
            house_detail_motto?.text = it.motto
        }
    }

    private fun initRecyclerView(houseName: String) {
        house_detail_recycler?.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        house_detail_recycler?.setHasFixedSize(true)
        house_detail_recycler?.adapter = adapter
        adapter.setHouseMembers(HouseRepository.getPeopleForHouse(houseName))
    }

    override fun onPersonClicked(person: Person) {
        val action = HouseDetailFragmentDirections.toPersonDest(person.house.name, person.givenName)
        findNavController().navigate(action)
    }

}