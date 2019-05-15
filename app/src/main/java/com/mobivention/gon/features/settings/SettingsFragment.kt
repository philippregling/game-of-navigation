package com.mobivention.gon.features.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobivention.gon.features.BaseFragment
import com.mobivention.gon.features.main.HouseRepository
import com.mobivention.gon.model.House
import com.mobivention.gon.utility.PrefsUtil
import com.mobivention.myapplication.R
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BaseFragment(),
    SettingsAdapter.Listener {

    val adapter: SettingsAdapter by lazy {
        SettingsAdapter(
            this
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar(getString(R.string.house_settings), true)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        settings_recycler?.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        settings_recycler?.setHasFixedSize(true)
        settings_recycler?.adapter = adapter
        adapter.setHouses(HouseRepository.houses)
    }

    override fun onHouseToggled(house: House, isChecked: Boolean) {
        activity?.let {
            if (isChecked) {
                PrefsUtil.addInactiveHouse(it, house)
            } else {
                PrefsUtil.removeInactiveHouse(it, house)
            }
        }
    }

}