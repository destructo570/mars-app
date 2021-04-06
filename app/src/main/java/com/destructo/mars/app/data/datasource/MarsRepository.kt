package com.destructo.mars.app.data.datasource

import androidx.lifecycle.MutableLiveData
import com.destructo.mars.app.data.response.marsImages.MarsImages
import com.destructo.mars.app.room.MarsImageListDao
import com.destructo.mars.app.util.GENERIC_ERROR
import javax.inject.Inject

class MarsRepository @Inject constructor(
    private val marsApi: MarsApi,
    private val marsImageListDao: MarsImageListDao
) {

    val getAllImages = marsImageListDao.getAllImages()

    val marsImageList = MutableLiveData<Resource<MarsImages>>()

    private var nextPage: Int = 1

    suspend fun getLatestMarsImagesByRover(rover: String, sol: String) {
        marsImageList.postValue(Resource.loading(null))

        try {
            val response = marsApi.getMarsImageBySol(
                roverName = rover,
                page = nextPage.toString(),
                sol = sol
            )

            marsImageListDao.insertImageList(response.photos?.map {it.mapToDomainModel()})
            marsImageList.postValue(Resource.success(response))
            nextPage++

        } catch (error: Exception) {
            marsImageList.postValue(
                Resource.error(error.message ?: GENERIC_ERROR, null)
            )
        }
    }

    fun clearList() = marsImageListDao.deleteAllImages()

    fun clearNextPage() {
        nextPage = 1
    }

}