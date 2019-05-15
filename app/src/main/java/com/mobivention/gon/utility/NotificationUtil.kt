package com.mobivention.gon.utility

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.mobivention.myapplication.R

object NotificationUtil {

    fun sendNotification(context: Context) {
        val notificationManager = NotificationManagerCompat.from(context)

//        val args = HouseDetailFragmentArgs.Builder("Stark").build().toBundle()
//
//        val pendingIntent = NavDeepLinkBuilder(context)
//            .setArguments(args)
//            .setGraph(R.navigation.mobile_navigation)
//            .setDestination(R.id.fragment_house_detail_dest)
//            .createPendingIntent()

        createChannel(context)
        val notification = NotificationCompat.Builder(context, "Channel")
            .setContentTitle("Alarm!")
            .setContentText("Winter is coming!")
            .setSmallIcon(R.drawable.ic_ac_unit_black_24dp)
            //          .setContentIntent(pendingIntent)
            .build()
        notificationManager.notify(0, notification)

    }

    fun createChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel("Channel", "Channel", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

    }


}