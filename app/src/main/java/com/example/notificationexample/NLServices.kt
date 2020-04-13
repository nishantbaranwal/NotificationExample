package com.example.notificationexample

import android.annotation.SuppressLint
import android.app.Notification
import android.os.Build
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import androidx.annotation.RequiresApi

@SuppressLint("OverrideAbstract")
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
class NLServices : NotificationListenerService() {
    companion object {
        val TAG:String = this::class.java.simpleName
    }
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        try {
            Log.d(TAG,"active_notification "+ activeNotifications.size.toString())
        }
        catch (e:Exception){
            Log.d(TAG,"exception_is "+e.message)
        }
    }
}