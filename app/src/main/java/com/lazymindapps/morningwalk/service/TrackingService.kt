package com.lazymindapps.morningwalk.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import com.lazymindapps.morningwalk.MainActivity
import com.lazymindapps.morningwalk.R
import com.lazymindapps.morningwalk.utli.Constants.ACTION_PAUSE
import com.lazymindapps.morningwalk.utli.Constants.ACTION_START_RESUME
import com.lazymindapps.morningwalk.utli.Constants.ACTION_STOP
import com.lazymindapps.morningwalk.utli.Constants.ACTION_TRACKING_FRAGMENT
import com.lazymindapps.morningwalk.utli.Constants.NOTIFICATION_CHANNEL_ID
import com.lazymindapps.morningwalk.utli.Constants.NOTIFICATION_CHANNEL_NAME
import com.lazymindapps.morningwalk.utli.Constants.NOTIFICATION_ID
import timber.log.Timber

class TrackingService : LifecycleService() {
    var isFirstClick = true

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action){
                ACTION_START_RESUME ->{
                    if (isFirstClick){
                        startForgroundService()
                        isFirstClick = false
                    } else{
                        Timber.d("Resuming existing service")
                    }
                }

                ACTION_PAUSE ->{
                    Timber.d("Service paused")
                }
                ACTION_STOP ->{
                    Timber.d("Service Stoped")
                }
            }

        }
        return super.onStartCommand(intent, flags, startId)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notification:NotificationManager){

        val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,IMPORTANCE_LOW)
        notification.createNotificationChannel(channel)

    }

    private fun startForgroundService(){
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ){
            createNotificationChannel(notificationManager)
        }
        val notificationBuilder =  NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_baseline_directions_walk_24)
            .setContentTitle("Morning Walk")
            .setContentText("00:00:00")
            .setContentIntent(getPendingIntentMainActivity())

        startForeground(NOTIFICATION_ID,notificationBuilder.build())


    }


    private fun getPendingIntentMainActivity() = PendingIntent.getActivity(
        this,0,Intent(this,MainActivity::class.java).also {
            it.action = ACTION_TRACKING_FRAGMENT
        },FLAG_UPDATE_CURRENT
    )
}