package com.lazymindapps.morningwalk.di

import android.content.Context
import androidx.room.Room
import com.lazymindapps.morningwalk.db.WalkingDatabase
import com.lazymindapps.morningwalk.utli.Constants.WALKING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Singleton
    @Provides
    fun providingWalkingDatabase(@ApplicationContext context:Context) = Room.databaseBuilder(
        context,
        WalkingDatabase::class.java,
        WALKING_DATABASE_NAME,
    ).build()


    @Singleton
    @Provides
    fun provideWalkDao(db:WalkingDatabase) = db.getWalkDao()
}