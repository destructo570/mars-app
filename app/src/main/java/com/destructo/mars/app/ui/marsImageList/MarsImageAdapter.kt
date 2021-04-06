package com.destructo.mars.app.ui.marsImageList

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.destructo.mars.app.data.domainModel.PhotoModel
import com.destructo.mars.app.data.response.common.PhotoResponse
import com.destructo.mars.app.listener.ListEndListener

class MarsImageAdapter (
    private val latestPhotoListener: (PhotoModel) -> Unit):
    ListAdapter<PhotoModel, MarsImageViewHolder>(LatestPhotoDiffCallback()) {

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

class LatestPhotoDiffCallback : DiffUtil.ItemCallback<PhotoModel>() {
    override fun areItemsTheSame(oldItem: PhotoModel, newItem: PhotoModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhotoModel, newItem: PhotoModel): Boolean {
        return oldItem == newItem
    }

}