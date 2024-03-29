package com.example.materialchipsandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_filter_chip.*
import kotlinx.android.synthetic.main.fragment_filter_chip.view.*

class FilterChipFragment : Fragment() {

    var adapter: FilterChipListAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_filter_chip, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FilterChipListAdapter()
        recyclerview_filter.layoutManager = LinearLayoutManager(context)
        recyclerview_filter.adapter = adapter

        val list= mutableListOf<String>()


        chip_group_filter.setOnCheckedChangeListener { group, checkedId ->
            val chip: Chip? = group.findViewById(checkedId)
            Toast.makeText(
                context,
                "inside set on",
                Toast.LENGTH_LONG
            ).show()
            if (chip != null) {
                if(chip.isChecked)
                    if (chip != null) {
                        list.add(chip.text.toString())
                    }
                    else
                        if (chip != null) {
                            list.remove(chip.text.toString())
                        }
            }
            // Set the chip checked change listener
            Toast.makeText(
                context,
                list.toString(),
                Toast.LENGTH_LONG
            ).show()

        }







        //  adapter?.setData(prepareData())

    }


    fun updateData(view: View){
        val chip = view as Chip

        val predicate: (Items) -> Boolean = {
            it.category == chip.text
        }
        val filter = prepareData().filter(predicate)
        adapter?.setData(filter)
    }

    fun prepareData(): MutableList<Items> {
        val data = mutableListOf<Items>()
        data.add(Items("Food 1","Fast Delivery"))
        data.add(Items("Food 2","Pickup"))
        data.add(Items("Food 3","Best Offer"))
        data.add(Items("Food 4","Fast Selling"))
        data.add(Items("Food 5","Fast Delivery"))
        data.add(Items("Food 6","Pickup"))
        data.add(Items("Food 7","Fast Delivery"))
        data.add(Items("Food 8","Pickup"))
        return data
    }

    companion object {

        @JvmStatic
        fun newInstance() = FilterChipFragment()
    }

}