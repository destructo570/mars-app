package com.destructo.mars.app.data.model.common


import com.squareup.moshi.Json

data class CameraResponse(
    @Json(name = "full_name")
    val fullName: String?=null,
    @Json(name = "id")
    val id: Int?=null,
    @Json(name = "name")
    val name: String?=null,
    @Json(name = "rover_id")
    val roverId: Int?=null
)