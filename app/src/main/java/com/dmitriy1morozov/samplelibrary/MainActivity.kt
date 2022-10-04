package com.dmitriy1morozov.samplelibrary

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.dmitriy1morozov.sample.library.EntryPoint


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnGo).setOnClickListener {
            EntryPoint.sendNotification(
                this,
                R.drawable.ic_launcher_foreground
            )
        }

        findViewById<Button>(R.id.btnCrashApp).setOnClickListener {
            throw NullPointerException("App crash2")
        }

        findViewById<Button>(R.id.btnCrashSdk).setOnClickListener {
            EntryPoint.crash()
        }




//        thread {
//            val adsId = AdvertisingIdClient.getAdvertisingIdInfo(this)
//            Log.d("tag", "onCreate: adsId = ${adsId.id}")
//
//            val mId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
//            Log.d("tag", "onCreate: deviceId = $mId")
//        }
    }
}