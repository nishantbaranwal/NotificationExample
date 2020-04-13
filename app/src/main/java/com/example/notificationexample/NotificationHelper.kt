package com.example.notificationexample

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationChannel.DEFAULT_CHANNEL_ID
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat


class NotificationHelper(private val mContext: Context) {
    private var mNotificationManager: NotificationManager? = null
    private var mBuilder: NotificationCompat.Builder? = null
    /**
     * Create and push the notification
     */
    fun createNotification(title: String?, message: String?) {
        val notifyIntent = Intent(android.provider.Settings.ACTION_SETTINGS)
            notifyIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val notifyPendingIntent = PendingIntent.getActivity(
                mContext, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )
        mBuilder = NotificationCompat.Builder(mContext,NOTIFICATION_CHANNEL_ID)
        mBuilder!!.setSmallIcon(R.mipmap.ic_launcher)
        mBuilder!!.setContentTitle(title)
                  .setContentText(message)
//                  .setCategory(Notification.CATEGORY_RECOMMENDATION)
                  .setAutoCancel(false)
                .setContentIntent(notifyPendingIntent)


        mNotificationManager =
            mContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel(
                    "account",
                "NOTIFICATION_CHANNEL_NAME",
                importance
            )
            mBuilder!!.setChannelId(NOTIFICATION_CHANNEL_ID)
            mNotificationManager!!.createNotificationChannel(notificationChannel)
            mNotificationManager!!.createNotificationChannel(notificationChannel)

        }
        assert(mNotificationManager != null)
        mNotificationManager!!.notify(0 /* Request Code */, mBuilder!!.build())

        //        var statusBarNotification sbn =
//                    Xposed.getObjectField(entry, "notification");
//        val CLASS_NOTIF_DATA = "com.android.systemui.statusbar.NotificationData"
//        val CLASS_BASE_STATUSBAR = "com.android.systemui.statusbar.BaseStatusBar"
//        var abc=Class.forName(CLASS_BASE_STATUSBAR ,false,context!!.getClassLoader())
//        Log.d("clasSnA",abc::class.java.simpleName)
    }

    companion object {
        const val NOTIFICATION_CHANNEL_ID = "10001"
    }

}