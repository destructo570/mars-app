package com.destructo.mars.app.data.datasource

import com.destructo.mars.app.data.response.latestImages.LatestImages
import com.destructo.mars.app.data.response.marsImages.MarsImages
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

    @GET("rovers/{rover_name}/photos")
    suspend fun getMarsImageBySol(
        @Path("rover_name") roverName: String,
        @Query("sol") sol: String,
        @Query("page") page: String,
        @Query("api_key") apiKey: String = API_KEY,
    ): MarsImages
}