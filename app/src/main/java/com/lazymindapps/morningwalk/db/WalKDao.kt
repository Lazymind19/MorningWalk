package com.lazymindapps.morningwalk.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface WalKDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWalk(walk: Walk)

    @Delete
    suspend fun deleteWalk(walk: Walk)


    @Query("Select * from walk_table ORDER BY timeStamp desc")
    fun getAllWalkSortedByDate():LiveData<List<Walk>>

    @Query("Select * from walk_table ORDER BY timeInMIllis desc")
    fun getAllWalkSortedByTimeInMillis():LiveData<List<Walk>>

    @Query("Select * from walk_table ORDER BY calaryBurn desc")
    fun getAllWalkSortedByCaloryBurn():LiveData<List<Walk>>

    @Query("Select * from walk_table ORDER BY avgSpeedInKm desc")
    fun getAllWalkSortedByAverageSpeed():LiveData<List<Walk>>


    @Query("Select SUM(timeInMIllis) from walk_table")
    fun totalWalkingTime():LiveData<Long>
}