package com.destructo.mars.app.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.destructo.mars.app.data.domainModel.PhotoModel
import com.destructo.mars.app.data.response.common.PhotoResponse

@TypeConverters(value = [TypeConverter::class])
@Database(entities = [PhotoModel::class], version = 1, exportSchema = false)
abstract class MarsAppDatabase :RoomDatabase(){

    abstract fun marsImageListDao():MarsImageListDao

    companion object{
        const val DATABASE_NAME = "mars_app_database"
    }

}