package com.destructo.mars.app.room

import androidx.room.TypeConverter
import com.destructo.mars.app.data.response.common.CameraResponse
import com.destructo.mars.app.data.response.common.RoverResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class TypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun cameraResponseToString(data: CameraResponse?): String?{
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToCameraResponse(data: String?): CameraResponse?{
        if(data == null) return null

        val type: Type = object: TypeToken<CameraResponse?>(){}.type
        return  gson.fromJson(data, type)
    }

    @TypeConverter
    fun roverResponseToString(data: RoverResponse?): String?{
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToRoverResponse(data: String?): RoverResponse?{
        if(data == null) return null

        val type: Type = object: TypeToken<RoverResponse?>(){}.type
        return  gson.fromJson(data, type)
    }

}