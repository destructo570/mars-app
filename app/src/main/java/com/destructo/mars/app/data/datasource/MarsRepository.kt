package com.destructo.mars.app.data.datasource

import androidx.lifecycle.MutableLiveData
import com.destructo.mars.app.data.response.marsImages.MarsImages
import com.destructo.mars.app.room.MarsImageListDao
import com.destructo.mars.app.util.GENERIC_ERROR
import java.lang.Exception
import javax.inject.Inject

class MarsRepository @Inject constructor(
    private val marsApi: MarsApi,
    private val marsImageListDao: MarsImageListDao
) {

    val getAllImages = marsImageListDao.getAllImages()

    val marsImageList = MutableLiveData<Resource<MarsImages>>()

    private var nextSol: Int = 0

    suspend fun getLatestMarsImagesByRover(rover: String, sol: String) {
        marsImageList.value = Resource.loading(null)
        try {
            val response = marsApi.getMarsImageBySol(
                roverName = rover,
                page = nextSol.toString(),
                sol = sol
            )
            marsImageListDao.insertImageList(response.photos?.map {it.mapToDomainModel()})
            marsImageList.value = Resource.success(response)
            nextSol++

        } catch (error: Exception) {
            marsImageList.value = Resource.error(error.message ?: GENERIC_ERROR, null)
        }
    }

    fun clearList() = marsImageListDao.deleteAllImages()

    fun clearNextSol() {
        nextSol = 0
    }

}