package com.destructo.mars.app.ui.roverList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.destructo.mars.app.R
import com.destructo.mars.app.data.model.Rover

class RoverListAdapter: RecyclerView.Adapter<RoverListAdapter.ViewHolder>() {

    var data = listOf<Rover>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder private constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        private val roverName: TextView = itemView.findViewById(R.id.rover_name)
        private val roverImage: ImageView = itemView.findViewById(R.id.rover_image)

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_item_rover, parent, false)
                return ViewHolder(view)
            }
        }

        fun bind(item: Rover) {
            roverName.text = item.name
            roverImage.setImageResource(item.image)
        }

    }



}