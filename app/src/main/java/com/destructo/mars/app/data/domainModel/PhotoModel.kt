package com.destructo.mars.app.data.domainModel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.destructo.mars.app.data.response.common.CameraResponse
import com.destructo.mars.app.data.response.common.PhotoResponse
import com.destructo.mars.app.data.response.common.RoverResponse
import com.destructo.mars.app.util.CACHE_EXPIRE
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "mars_image_list")
data class PhotoModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val photoId: Int,
    val camera: CameraResponse?,
    val earthDate: String,
    val imgSrc: String,
    val rover: RoverResponse?,
    val sol: Int = 0,
    val saved_time: Long = System.currentTimeMillis()
) : DomainMapper<PhotoResponse>, Parcelable {

    fun isExpired(): Boolean {
        return (System.currentTimeMillis() - saved_time) > CACHE_EXPIRE
    }

    override fun mapToDomainModel(): PhotoResponse {
        return PhotoResponse(
            camera = camera, rover = rover, earthDate = earthDate,
            imgSrc = imgSrc, sol = sol, id = photoId
        )
    }
}

