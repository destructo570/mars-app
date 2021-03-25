package com.destructo.mars.app.data.model.latestPhoto


import com.destructo.mars.app.data.model.latestPhoto.LatestPhoto
import com.squareup.moshi.Json

data class MarsImage(
    @Json(name = "latest_photos")
    val latestPhotos: List<LatestPhoto>
)