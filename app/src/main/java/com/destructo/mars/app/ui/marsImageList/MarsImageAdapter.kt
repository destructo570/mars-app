package com.destructo.mars.app.ui.marsImageList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.destructo.mars.app.data.model.common.PhotoResponse
import com.destructo.mars.app.databinding.ListItemMarsImageBinding
import com.destructo.mars.app.listener.ListEndListener

class MarsImageAdapter (
    private val latestPhotoListener: (PhotoResponse) -> Unit):
    ListAdapter<PhotoResponse, MarsImageViewHolder>(LatestPhotoDiffCallback()) {

    private var listEndListener: ListEndListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsImageViewHolder {
        return MarsImageViewHolder.from(parent, latestPhotoListener)
    }

    override fun onBindViewHolder(holder: MarsImageViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
        if (position == currentList.size - 2) run {
            listEndListener?.onEndReached(position)
        }

    }

    fun setListEndListener(listEndListener: ListEndListener){
        this.listEndListener = listEndListener
    }

}

class LatestPhotoDiffCallback : DiffUtil.ItemCallback<PhotoResponse>() {
    override fun areItemsTheSame(oldItem: PhotoResponse, newItem: PhotoResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhotoResponse, newItem: PhotoResponse): Boolean {
        return oldItem == newItem
    }

}