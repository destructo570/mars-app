package com.destructo.mars.app.data.model.latestPhoto


import com.destructo.mars.app.data.model.common.Rover
import com.squareup.moshi.Json

data class LatestPhoto(
    @Json(name = "camera")
    val camera: Camera?=null,
    @Json(name = "earth_date")
    val earthDate: String?=null,
    @Json(name = "id")
    val id: Int?=null,
    @Json(name = "img_src")
    val imgSrc: String?=null,
    @Json(name = "rover")
    val rover: Rover?=null,
    @Json(name = "sol")
    val sol: Int?=null
)