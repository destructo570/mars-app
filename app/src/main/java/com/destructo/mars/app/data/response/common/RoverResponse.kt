package com.destructo.mars.app.data.response.common

import com.squareup.moshi.Json

data class RoverResponse(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "status")
        val status: String? = null,
        @Json(name = "landing_date")
        val landingDate: String? = null,
        @Json(name = "launch_date")
        val launchDate: String? = null,
)
