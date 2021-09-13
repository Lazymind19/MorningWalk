package com.lazymindapps.morningwalk.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(entities = [Walk::class],version = 1)

@TypeConverters(Converters::class)
abstract class WalkingDatabase:RoomDatabase() {
    abstract fun getWalkDao(): WalKDao
}