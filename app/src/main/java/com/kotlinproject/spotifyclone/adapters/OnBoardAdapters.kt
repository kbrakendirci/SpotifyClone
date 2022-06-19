package com.kotlinproject.spotifyclone.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlinproject.spotifyclone.Data.OnBoard
import com.kotlinproject.spotifyclone.R

class OnBoardAdapters(var context: Context?) : RecyclerView.Adapter<OnBoardAdapters.ViewHolder>() {

    var dataList = emptyList<OnBoard>()

    internal fun setDataList(dataList: List<OnBoard>) {
        this.dataList = dataList
    }

    // Provide a direct reference to each of the views with data items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView

        init {

            image = itemView.findViewById(R.id.imagecard)
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
    override fun onBindViewHolder(holder: OnBoardAdapters.ViewHolder, position: Int) {

        // Get the data model based on position
        var data = dataList[position]

        // Set item views based on your views and data model
        holder.title.text = data.title


        holder.image.setImageResource(data.image)
    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size
}