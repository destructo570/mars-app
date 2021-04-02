package com.destructo.mars.app.di

import android.content.Context
import androidx.room.Room
import com.destructo.mars.app.room.MarsAppDatabase
import com.destructo.mars.app.room.MarsImageListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideMarsAppDatabase(@ApplicationContext context: Context): MarsAppDatabase{
        return Room.databaseBuilder(
            context.applicationContext,
            MarsAppDatabase::class.java,
            MarsAppDatabase.DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMarsImageListDao(sushiDatabase: MarsAppDatabase): MarsImageListDao{
        return sushiDatabase.marsImageListDao()
    }
}