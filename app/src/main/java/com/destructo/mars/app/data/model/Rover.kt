package com.destructo.mars.app.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rover(
        val name: String,
        val image: Int,
        val landedOn: String,
        val launchedOn: String,
        val missionName: String,
        val mainJob: String
): Parcelable
