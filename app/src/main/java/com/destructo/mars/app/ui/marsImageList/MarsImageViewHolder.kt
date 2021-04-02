package com.destructo.mars.app.ui.marsImageList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.destructo.mars.app.data.model.common.PhotoResponse
import com.destructo.mars.app.databinding.ListItemMarsImageBinding

class MarsImageViewHolder(
    private val binding: ListItemMarsImageBinding,
    private val latestPhotoListener: (PhotoResponse) -> Unit,
): RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup,
                 latestPhotoListener:(PhotoResponse) -> Unit
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

    fun bind(latestPhoto: PhotoResponse) {
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