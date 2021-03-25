package com.destructo.mars.app.data.model.common


import com.squareup.moshi.Json

data class PhotoResponse(
    @Json(name = "camera")
    val camera: CameraResponse?=null,
    @Json(name = "earth_date")
    val earthDate: String?=null,
    @Json(name = "id")
    val id: Int?=null,
    @Json(name = "img_src")
    val imgSrc: String?=null,
    @Json(name = "rover")
    val rover: RoverResponse?=null,
    @Json(name = "sol")
    val sol: Int?=null
)