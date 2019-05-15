package com.mobivention.gon.features.main.houses.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mobivention.gon.model.Person
import com.mobivention.myapplication.R
import kotlinx.android.synthetic.main.item_person.view.*

class HouseDetailAdapter(val listener: Listener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var data: MutableList<Person> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PersonHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.item_person, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PersonHolder) {
            holder.onBind(data[position], listener)
        }
    }

    fun setHouseMembers(listOfHouseMembers: List<Person>) {
        val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return data.getOrNull(oldItemPosition) == listOfHouseMembers.getOrNull(newItemPosition)
            }

            override fun getOldListSize(): Int {
                return data.size
            }

            override fun getNewListSize(): Int {
                return listOfHouseMembers.size
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return data.getOrNull(oldItemPosition) == listOfHouseMembers.getOrNull(newItemPosition)
            }

        })
        data.clear()
        data.addAll(listOfHouseMembers)
        result.dispatchUpdatesTo(this)
    }


    class PersonHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(person: Person, listener: Listener) {
            itemView.item_person_name?.text = "${person.givenName} ${person.surname}"
            itemView.setOnClickListener {
                listener.onPersonClicked(person)
            }
        }

    }

    interface Listener {

        fun onPersonClicked(person: Person)

    }

}