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
    fun getAllRunSortedByDate():LiveData<List<Walk>>

    @Query("Select * from walk_table ORDER BY timeInMIllis desc")
    fun getAllRunSortedByTimeInMillis():LiveData<List<Walk>>

    @Query("Select * from walk_table ORDER BY calaryBurn desc")
    fun getAllRunSortedByCaloryBurn():LiveData<List<Walk>>

    @Query("Select * from walk_table ORDER BY avgSpeedInKm desc")
    fun getAllRunSortedByAverageSpeed():LiveData<List<Walk>>


    @Query("Select SUM(timeInMIllis) from walk_table")
    fun totalWalkingTime():LiveData<Long>
}