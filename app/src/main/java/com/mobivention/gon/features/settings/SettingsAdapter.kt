package com.mobivention.gon.features.settings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mobivention.gon.features.main.HouseRepository
import com.mobivention.gon.model.House
import com.mobivention.myapplication.R
import kotlinx.android.synthetic.main.item_house_setting.view.*

class SettingsAdapter(val listener: Listener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: MutableList<House> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HouseHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_house_setting,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HouseHolder) {
            holder.onBind(data[position], listener)
        }
    }

    fun setHouses(listOfHouses: List<House>) {
        val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return data.getOrNull(oldItemPosition) == listOfHouses.getOrNull(newItemPosition)
            }

            override fun getOldListSize(): Int {
                return data.size
            }

            override fun getNewListSize(): Int {
                return listOfHouses.size
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return data.getOrNull(oldItemPosition) == listOfHouses.getOrNull(newItemPosition)
            }

        })
        data.clear()
        data.addAll(listOfHouses)
        result.dispatchUpdatesTo(this)
    }


    class HouseHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(house: House, listener: Listener) {
            itemView.context?.let {
                itemView.item_settings_house_name?.text = house.name
                itemView.item_settings_house_switch?.isChecked = HouseRepository.isHouseInactive(it, house)
                itemView.item_settings_house_switch?.setOnCheckedChangeListener { _, isChecked ->
                    listener.onHouseToggled(house, isChecked)
                }
            }
        }

    }

    interface Listener {

        fun onHouseToggled(house: House, isChecked: Boolean)

    }

}