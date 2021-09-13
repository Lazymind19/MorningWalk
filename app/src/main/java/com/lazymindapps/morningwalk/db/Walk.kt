package com.lazymindapps.morningwalk.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "walk_table")
data class Walk (
    var img:Bitmap?=null,
    var timeStamp:Long = 0L,
    var avgSpeedInKm:Float=0f,
    var distanceinMeter:Int = 0,
    var timeInMIllis:Long =0L,
    var calaryBurn:Int = 0


        ){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null

}