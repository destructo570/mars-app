package com.destructo.mars.app.data.response.common


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class CameraResponse(
    @Json(name = "full_name")
    val fullName: String?=null,
    @Json(name = "id")
    val id: Int?=null,
    @Json(name = "name")
    val name: String?=null,
    @Json(name = "rover_id")
    val roverId: Int?=null
): Parcelable