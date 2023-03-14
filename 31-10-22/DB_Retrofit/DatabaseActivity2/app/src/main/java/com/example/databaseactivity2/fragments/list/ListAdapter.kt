package com.example.databaseactivity2.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseactivity2.R
import com.example.databaseactivity2.model.Student
import com.example.databaseactivity2.viewmodel.StudentViewModel

class ListAdapter(private val list: List<Student>): RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var studentId = itemView.findViewById<TextView>(R.id.studentID)
        var studentName = itemView.findViewById<TextView>(R.id.studentName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student = list[position]
        holder.studentId.text = student.id.toString()
        holder.studentName.text = student.name
    }

    override fun getItemCount(): Int {
        return list.size
    }

}