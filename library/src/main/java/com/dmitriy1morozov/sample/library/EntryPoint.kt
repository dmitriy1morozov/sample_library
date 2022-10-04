package com.dmitriy1morozov.sample.library

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.provider.Telephony.Mms.Sent
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import com.dmitriy1morozov.sample.library.SentryCrashReporter.SENTRY_DSN
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.gms.appset.AppSet
import com.google.android.gms.appset.AppSetIdInfo
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.tasks.Task
import io.sentry.Sentry
import kotlin.concurrent.thread


object EntryPoint {
    val TAG: String = EntryPoint::class.java.simpleName

    fun initialize(application: Application) {
        val client = AppSet.getClient(application)
        val task: Task<AppSetIdInfo> = client.appSetIdInfo

        task.addOnSuccessListener {
            // Determine current scope of app set ID.
            val scope: Int = it.scope

            // Read app set ID value, which uses version 4 of the
            // universally unique identifier (UUID) format.
            val id: String = it.id
            Log.d("EntryPoint", "initialize: AppSetId = $id, scope = $scope")

            thread {
                if (isGooglePlayServicesAvailable(application)) {
                    val adsId = AdvertisingIdClient.getAdvertisingIdInfo(application)
                    Log.d("EntryPoint", "initialize: AdsId = ${adsId.id}")
                }
            }



            val secureId =
                Settings.Secure.getString(application.contentResolver, Settings.Secure.ANDROID_ID)
            Log.d("EntryPoint", "initialize: secureId = $secureId")
        }
    }


    fun sendNotification(context: Context, @DrawableRes icon: Int) {
        createChannel(context)
        val notificationManager =
            context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(context, InterceptorActivity::class.java).apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse("https://www.google.com/")
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }
        val pendingIntent =
            PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT)


        val builder = NotificationCompat.Builder(context, "CHANNEL_ID")
            .setSmallIcon(icon)
            .setContentTitle("textTitle")
            .setContentText("textContent")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        thread {
            Thread.sleep(3000)
            Log.d("tag", "sendNotification: Thread awaken")
            notificationManager.notify(0, builder.build())
        }
    }

    private fun createChannel(context: Context) {
        val name = "default"
        val descriptionText = "description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val mChannel = NotificationChannel("CHANNEL_ID", name, importance)
        mChannel.description = descriptionText
        // Register the channel with the system; you can't change the importance
        // or other notification behaviors after this
        val notificationManager =
            context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(mChannel)
    }

    private fun isGooglePlayServicesAvailable(context: Context): Boolean {
        val googleApiAvailability = GoogleApiAvailability.getInstance()
        val resultCode = googleApiAvailability.isGooglePlayServicesAvailable(context)
        return resultCode == ConnectionResult.SUCCESS
    }

    @Throws
    fun crash() {
        someFunction()
    }

    @Throws
    private fun someFunction() {
        try {
            Log.d(TAG, "crash: throw exception")
            throw NumberFormatException("SDK crash2")
        } catch (e: java.lang.Exception) {
            Log.d(TAG, "crash: send crash to Sentry")
            SentryCrashReporter.reportError(e)
            Log.d(TAG, "crash: rethrow exception")
//            throw e
        }
    }
}