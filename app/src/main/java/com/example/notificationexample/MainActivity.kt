package com.example.notificationexample

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()

    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val intent = Intent(
                "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
            )
            startActivity(intent)
        }
//        val intent = Intent(
//            "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
//        )
//        startActivity(intent)
//        startActivityForResult(Intent("com.android.tv.action.OPEN_NOTIFICATIONS_PANEL"), 0)

        createChannels()

//        val notificationManger = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        val myNotificationChannel = notificationManger.getNotificationChannel("account")
//        Log.d("Notification_Channel",myNotificationChannel.name.toString())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createChannels() {
        val notificationHelper = NotificationHelper(this@MainActivity)
        notificationHelper.createNotification("Oreo Notification", "This is oreo")
    }
}
