package com.destructo.mars.app.data.model.latestImages


import com.destructo.mars.app.data.model.common.PhotoResponse
import com.squareup.moshi.Json

data class LatestImages(
    @Json(name = "latest_photos")
    val photos: List<PhotoResponse>
)