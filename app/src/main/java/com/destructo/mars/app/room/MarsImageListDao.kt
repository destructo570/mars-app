package com.destructo.mars.app.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.destructo.mars.app.data.domainModel.PhotoModel
import com.destructo.mars.app.data.response.common.PhotoResponse

@Dao
interface MarsImageListDao {

    @Query("SELECT * from mars_image_list")
    fun getAllImages():LiveData<List<PhotoModel>>

    @Query("DELETE FROM mars_image_list")
    fun deleteAllImages()

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insertImageList(marsImageList: List<PhotoModel>?)
}