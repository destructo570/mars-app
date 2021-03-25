package com.destructo.mars.app.data.model.rover

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rover(
    val id: Int? = null,
    val name: String? = null,
    val landingDate: String? = null,
    val launchDate: String? = null,
    val image: Int? = null,
    val missionName: String? = null,
    val mainJob: String? = null
): Parcelable
