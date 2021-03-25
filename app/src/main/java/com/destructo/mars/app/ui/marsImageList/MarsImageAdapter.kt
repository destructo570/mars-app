package com.destructo.mars.app.ui.marsImageList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.destructo.mars.app.data.model.common.Photo
import com.destructo.mars.app.databinding.ListItemMarsImageBinding

class MarsImageAdapter (
    private val latestPhotoListener: (Photo) -> Unit):
    ListAdapter<Photo, MarsImageAdapter.ViewHolder>(LatestPhotoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item, latestPhotoListener)
        }
    }

    class ViewHolder(
        private val binding: ListItemMarsImageBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(latestPhoto: Photo, latestPhotoListener: (Photo) -> Unit) {
            binding.apply {
                marsImage
                    .load(latestPhoto.imgSrc) {
                        crossfade(true)
                        crossfade(200)
                    }
                roverName.text = latestPhoto.earthDate

                root.setOnClickListener {
                    latestPhotoListener(latestPhoto)
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding = ListItemMarsImageBinding.inflate(
                    LayoutInflater
                        .from(parent.context), parent, false
                )
                return ViewHolder(binding)
            }
        }

    }

}

class LatestPhotoDiffCallback : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }

}