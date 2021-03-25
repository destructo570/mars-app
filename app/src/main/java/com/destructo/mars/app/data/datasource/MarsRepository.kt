package com.destructo.mars.app.data.datasource

import androidx.lifecycle.MutableLiveData
import com.destructo.mars.app.data.model.latestImages.LatestImages
import com.destructo.mars.app.util.GENERIC_ERROR
import java.lang.Exception
import javax.inject.Inject

class MarsRepository @Inject constructor(
    private val marsApi: MarsApi
) {

    val marsImage = MutableLiveData<Resource<LatestImages>>()

    suspend fun getLatestMarsImagesByRover(rover: String) {
        marsImage.value = Resource.loading(null)
        try {
            val response = marsApi.getLatestMarsImage(roverName = rover)
            marsImage.value = Resource.success(response)
        } catch (error: Exception) {
            marsImage.value = Resource.error(error.message ?: GENERIC_ERROR, null)
        }
    }

}