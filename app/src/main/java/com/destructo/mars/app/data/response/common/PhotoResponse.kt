package com.destructo.mars.app.data.response.common


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.destructo.mars.app.data.domainModel.DomainMapper
import com.destructo.mars.app.data.domainModel.PhotoModel
import com.destructo.mars.app.util.CACHE_EXPIRE
import com.destructo.mars.app.util.UNDEFINED
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
): DomainMapper<PhotoModel>{

    override fun mapToDomainModel(): PhotoModel {
        return PhotoModel(camera = camera, rover = rover, earthDate = earthDate ?: UNDEFINED,
            imgSrc = imgSrc ?: UNDEFINED , sol = sol ?: 0)
    }

}