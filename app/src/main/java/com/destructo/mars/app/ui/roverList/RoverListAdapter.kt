package com.destructo.mars.app.ui.roverList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.destructo.mars.app.R
import com.destructo.mars.app.data.response.rover.Rover

class RoverListAdapter(private val clickListener: (Rover) -> Unit): ListAdapter<Rover, RoverListAdapter.ViewHolder>(RoverDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        private val roverName: TextView = itemView.findViewById(R.id.rover_name)
        private val roverImage: ImageView = itemView.findViewById(R.id.rover_image)

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_item_rover, parent, false)
                return ViewHolder(view)
            }
        }

        fun bind(item: Rover, clickListener: (Rover) -> Unit) {
            roverName.text = item.name
            roverImage.setImageResource(item.image!!)
            itemView.setOnClickListener { clickListener(item) }
        }
    }

}

class RoverDiffUtilCallback: DiffUtil.ItemCallback<Rover>(){
    override fun areItemsTheSame(oldItem: Rover, newItem: Rover): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Rover, newItem: Rover): Boolean {
        return oldItem == newItem
    }

}