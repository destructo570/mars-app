package com.destructo.mars.app.data.response.rover

import android.os.Parcelable
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
