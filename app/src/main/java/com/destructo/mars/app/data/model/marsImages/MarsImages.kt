package com.destructo.mars.app.data.model.marsImages


import com.destructo.mars.app.data.model.common.PhotoResponse
import com.squareup.moshi.Json

data class MarsImages(
    @Json(name = "photos")
    var photos: List<PhotoResponse>?=null
)
