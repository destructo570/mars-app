package com.destructo.mars.app.data.datasource

import com.destructo.mars.app.data.model.latestImages.LatestImages
import com.destructo.mars.app.util.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarsApi {

    companion object{
        const val BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/"
    }

    @GET("rovers/{rover_name}/latest_photos")
    suspend fun getLatestMarsImage(
        @Path("rover_name") roverName: String,
        @Query("api_key") apiKey: String = API_KEY,
    ): LatestImages
}