package com.destructo.mars.app.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.destructo.mars.app.data.model.common.PhotoResponse
import com.destructo.mars.app.data.model.latestImages.LatestImages
import com.destructo.mars.app.data.model.marsImages.MarsImages
import com.destructo.mars.app.room.MarsImageListDao
import com.destructo.mars.app.util.GENERIC_ERROR
import retrofit2.Response
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class MarsRepository @Inject constructor(
    private val marsApi: MarsApi,
    private val marsImageListDao: MarsImageListDao
) {

    val getAllImages = marsImageListDao.getAllImages()

    val marsImageList = MutableLiveData<Resource<MarsImages>>()

    private var nextSol:Int = 0

    suspend fun getLatestMarsImagesByRover(rover: String) {
        marsImageList.value = Resource.loading(null)
        try {
            val response = marsApi.getMarsImageBySol(roverName = rover, sol = nextSol.toString())

            marsImageListDao.insertImageList(response.photos)
            marsImageList.value = Resource.success(response)
            nextSol++

        } catch (error: Exception) {
            marsImageList.value = Resource.error(error.message ?: GENERIC_ERROR, null)
        }
    }

    fun clearList() = marsImageListDao.deleteAllImages()

}