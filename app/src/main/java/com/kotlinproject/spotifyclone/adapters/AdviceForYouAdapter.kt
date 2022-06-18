package com.kotlinproject.spotifyclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kotlinproject.spotifyclone.Data.AdviceForYouDTO
import com.kotlinproject.spotifyclone.R

class AdviceForYouAdapter(val adviceForYouList: ArrayList<AdviceForYouDTO>) : RecyclerView.Adapter<AdviceForYouAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = LayoutInflater.from(parent.context).inflate(R.layout.container_advice_for_you, parent, false)
        return ViewHolder(vh)
    }

    override fun getItemCount(): Int {
        return adviceForYouList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imgAdviceCover = holder.itemView.findViewById<ImageView>(R.id.imgAdvice_Album_Cover)
        val imgAdviceTitle = holder.itemView.findViewById<TextView>(R.id.txtAdviceTitle)
        Glide.with(holder.itemView)
            .apply { RequestOptions().override(120, 120).fitCenter() }
            .load(adviceForYouList[position].imgURL)
            .into(imgAdviceCover)
        holder.imgAdviceTitle.text = adviceForYouList[position].title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgAdviceCover = itemView.findViewById<ImageView>(R.id.imgAdvice_Album_Cover)!!
        val imgAdviceTitle = itemView.findViewById<TextView>(R.id.txtAdviceTitle)!!
    }

}