package com.kat.recycleview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kat.recycleview.model.Club
import kotlinx.android.synthetic.main.item_list.view.*

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 9/7/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class ClubAdapter(
        private val context: Context,
        private val clubs:MutableList<Club>,
        private val listener:(Club) -> Unit
): RecyclerView.Adapter<ClubAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindItem(clubs[position],listener)

    override fun getItemCount(): Int = clubs.size

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {

        fun bindItem(club: Club, listener: (Club) -> Unit) {
            itemView.name.text   = club.name
            Glide.with(itemView.context).load(club.image).into(itemView.image)

            itemView.setOnClickListener {
                listener(club)
            }
        }
    }

}