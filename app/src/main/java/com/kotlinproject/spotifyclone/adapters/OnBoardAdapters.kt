package com.kotlinproject.spotifyclone.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kotlinproject.spotifyclone.Data.OnBoard
import com.kotlinproject.spotifyclone.R

class OnBoardAdapters(var context: Context?) : RecyclerView.Adapter<OnBoardAdapters.ViewHolder>() {

    var dataList = emptyList<OnBoard>()

    internal fun setDataList(dataList: List<OnBoard>) {
        this.dataList = dataList
    }

    // Provide a direct reference to each of the views with data items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageUrl: ImageView
        var title: TextView

        init {

            imageUrl = itemView.findViewById(R.id.imagecard)
            title = itemView.findViewById(R.id.titlecard)

        }

    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardAdapters.ViewHolder {

        // Inflate the custom layout
        var view = LayoutInflater.from(parent.context).inflate(R.layout.homelayoutcardview, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: OnBoardAdapters.ViewHolder, position: Int) {
        val imgAlbumCover = holder.itemView.findViewById<ImageView>(R.id.imagecard)

        // Get the data model based on position
        var data = dataList[position]

        // Set item views based on your views and data model
        holder.title.text = data.title
        Glide.with(holder.itemView)
            .apply { RequestOptions().override(120, 120).fitCenter() }
            .load(dataList[position].imageUrl)
            .into(imgAlbumCover)


        //holder.image.setImageResource(data.image)
    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size
}



