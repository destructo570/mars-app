package com.destructo.mars.app.ui.marsImageList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.destructo.mars.app.data.domainModel.PhotoModel
import com.destructo.mars.app.data.response.common.PhotoResponse
import com.destructo.mars.app.databinding.ListItemMarsImageBinding

class MarsImageViewHolder(
    private val binding: ListItemMarsImageBinding,
    private val latestPhotoListener: (PhotoModel) -> Unit,
): RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup,
                 latestPhotoListener:(PhotoModel) -> Unit
        ): MarsImageViewHolder {
            val binding = ListItemMarsImageBinding.inflate(
                LayoutInflater
                    .from(parent.context), parent, false
            )
            return MarsImageViewHolder(
                binding,
                latestPhotoListener
            )
        }
    }

    fun bind(latestPhoto: PhotoModel) {
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

}