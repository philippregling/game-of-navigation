package com.mobivention.gon.features.main.houses

import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobivention.gon.features.BaseFragment
import com.mobivention.gon.features.main.HouseRepository
import com.mobivention.gon.model.House
import com.mobivention.myapplication.R
import kotlinx.android.synthetic.main.fragment_houses.*

class HousesFragment : BaseFragment(),
    HousesAdapter.Listener {

    val adapter: HousesAdapter by lazy {
        HousesAdapter(
            this
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_houses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar(getString(R.string.houses), false)
        setHasOptionsMenu(true)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        houses_recycler?.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        houses_recycler?.setHasFixedSize(true)
        houses_recycler?.adapter = adapter
        context?.let {
            adapter.setHouses(HouseRepository.filterForActiveHouses(it))
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.settings_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onHouseClicked(house: House) {
        val action = HousesFragmentDirections.toHouseDetailDest(house.name)
        findNavController().navigate(action)
    }

}