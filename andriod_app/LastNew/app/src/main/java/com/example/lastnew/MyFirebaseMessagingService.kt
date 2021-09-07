package com.example.lastnew;

import android.app.Service;
import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    val TAG: String = "Towa"
    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        val a = FirebaseMessaging.getInstance().token
        Log.d(TAG, a.toString())
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: ${remoteMessage.from}")
        var b : String? = remoteMessage.notification?.body
        var c : String? = remoteMessage.notification?.imageUrl.toString()
        var a : String? = remoteMessage.notification?.title.toString()

        var detail = arrayOf<String?>(a,b,c)

        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
            Log.d(TAG, "Message image Url : ${it.imageUrl}")
        }
        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")

//            if (/* Check if data needs to be processed by long running job */ true) {
//                // For long-running tasks (10 seconds or more) use WorkManager.
//                scheduleJob()
//            } else {
//                // Handle message within 10 seconds
//                handleNow()
//            }
//        }
            // Check if message contains a notification payload.
            remoteMessage.notification?.let {
                Log.d(TAG, "Message Notification Body: ${it.body}")
                Log.d(TAG, "Message image Url : ${it.imageUrl}")
            }

            // Also if you intend on generating your own notifications as a result of a received FCM
            // message, here is where that should be initiated. See sendNotification method below.
        }
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("zzz",detail)
        }
        startActivity(intent)
    }
}