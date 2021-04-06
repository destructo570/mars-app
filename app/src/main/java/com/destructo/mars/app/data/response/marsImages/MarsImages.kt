package com.destructo.mars.app.data.response.marsImages


import com.destructo.mars.app.data.response.common.PhotoResponse
import com.squareup.moshi.Json

data class MarsImages(
    @Json(name = "photos")
    var photos: List<PhotoResponse>?=null
)
