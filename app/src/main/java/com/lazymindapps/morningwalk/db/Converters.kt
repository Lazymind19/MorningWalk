package com.lazymindapps.morningwalk.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class Converters {
    @TypeConverter
    fun fromBitMap(bmp:Bitmap):ByteArray{
        val outputStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG,100,outputStream)
        return  outputStream.toByteArray()
    }

    @TypeConverter
    fun toBitMap(byte:ByteArray):Bitmap{
        return BitmapFactory.decodeByteArray(byte,0,byte.size)
    }
}