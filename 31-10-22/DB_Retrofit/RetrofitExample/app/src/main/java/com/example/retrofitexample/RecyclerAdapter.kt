package com.example.retrofitexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val dataList: List<DataModel>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val death: TextView = itemView.findViewById(R.id.deathID)
        val cause: TextView = itemView.findViewById(R.id.causeID)
        val responsible: TextView = itemView.findViewById(R.id.responsibleID)
        val lastWords:TextView = itemView.findViewById(R.id.lastWordsID)
        val season:TextView = itemView.findViewById(R.id.seasonID)
        val episode:TextView = itemView.findViewById(R.id.episodeID)
        val numberOfDeath:TextView = itemView.findViewById(R.id.numberOfDeathsID)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val recyclerModel = dataList[position]
        holder.death.text = recyclerModel.death
        holder.cause.text = recyclerModel.cause
        holder.responsible.text = recyclerModel.responsible
        holder.lastWords.text = recyclerModel.last_words
        holder.season.text = recyclerModel.season.toString()
        holder.episode.text = recyclerModel.episode.toString()
        holder.numberOfDeath.text = recyclerModel.number_of_deaths.toString()

    }

    override fun getItemCount(): Int {
       return dataList.size
    }

}