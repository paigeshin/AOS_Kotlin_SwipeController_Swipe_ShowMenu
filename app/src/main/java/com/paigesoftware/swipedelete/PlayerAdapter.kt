package com.paigesoftware.swipedelete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_player.view.*

class PlayerAdapter(
    private val playerList: List<Player>
): RecyclerView.Adapter<PlayerAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val player = playerList[holder.adapterPosition]
        holder.itemView.name.text = player.name
        holder.itemView.nationality.text = player.nationality
        holder.itemView.club.text = player.club
        holder.itemView.rating.text = player.rating.toString()
        holder.itemView.age.text = player.age.toString()
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

}