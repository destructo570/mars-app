package com.destructo.mars.app.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.destructo.mars.app.data.model.latestPhoto.MarsImage
import retrofit2.Response
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class MarsRepository @Inject constructor(
    private val marsApi: MarsApi
) {

    val marsImage =  MutableLiveData<Resource<MarsImage>>()

    suspend fun getLatestMarsImagesByRover(rover: String){
        marsImage.value = Resource.loading(null)

        try {
            val response = marsApi.getLatestMarsImage(roverName = rover)
            marsImage.value = Resource.success(response)
        }catch (error: Exception){
            marsImage.value = Resource.error(error.message ?: "", null)
        }

    }

}