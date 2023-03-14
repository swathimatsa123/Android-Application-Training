package com.example.roomdatabaseactivity.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabaseactivity.R
import com.example.roomdatabaseactivity.model.User

class ListRecyclerAdapter: RecyclerView.Adapter<ListRecyclerAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val id = itemView.findViewById<View>(R.id.id_txt) as TextView
        val firstName = itemView.findViewById<TextView>(R.id.firstName_txt)
        val lastName = itemView.findViewById<TextView>(R.id.lastName_txt)
        val age = itemView.findViewById<TextView>(R.id.age_txt)
        val layout = itemView.findViewById<ConstraintLayout>(R.id.rowLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = userList[position]
       holder.id.text = list.id.toString()
        holder.firstName.text =list.firstName
        holder.lastName.text = list.lastName
        holder.age.text = list.age.toString()
        holder.layout.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(list) // <- Pass object to Update Fragment
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>?) {
        this.userList = user!!
        notifyDataSetChanged()
    }


}