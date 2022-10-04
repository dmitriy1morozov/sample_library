package com.dmitriy1morozov.sample.library

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class YespoPushBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("YespoPushBroadcastReceiver", "onReceive: ")
    }
}