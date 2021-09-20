package com.lazymindapps.morningwalk.repo

import com.lazymindapps.morningwalk.db.WalKDao
import com.lazymindapps.morningwalk.db.Walk
import javax.inject.Inject

class MainRepo @Inject constructor(
    val walKDao: WalKDao
) {

    suspend fun insertWalk(walk: Walk) = walKDao.insertWalk(walk)
    suspend fun deleteWalk(walk: Walk) = walKDao.deleteWalk(walk)

    fun getAllWalkSortedByDate() = walKDao.getAllWalkSortedByDate()
    fun getAllRunSortedByAverageSpeed() = walKDao.getAllWalkSortedByAverageSpeed()
    fun getAllWalkSortedByCaloryBurn() = walKDao.getAllWalkSortedByCaloryBurn()
    fun getAllWalkSortedByTimeInMillis() = walKDao.getAllWalkSortedByTimeInMillis()

    fun totalWalkingTime() = walKDao.totalWalkingTime()

}