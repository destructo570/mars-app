package com.destructo.mars.app.data.model.common


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.destructo.mars.app.util.CACHE_EXPIRE
import com.squareup.moshi.Json

@Entity(tableName = "mars_image_list")
data class PhotoResponse(
    @Json(name = "camera")
    val camera: CameraResponse?=null,
    @Json(name = "earth_date")
    val earthDate: String?=null,
    @Json(name = "id")
    @PrimaryKey
    val id: Int?=null,
    @Json(name = "img_src")
    val imgSrc: String?=null,
    @Json(name = "rover")
    val rover: RoverResponse?=null,
    @Json(name = "sol")
    val sol: Int?=null,
    val saved_time: Long=System.currentTimeMillis()
){
    private fun isExpired(): Boolean{
        return (System.currentTimeMillis() - saved_time) > CACHE_EXPIRE
    }
}