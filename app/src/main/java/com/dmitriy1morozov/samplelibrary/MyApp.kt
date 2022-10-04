package com.dmitriy1morozov.samplelibrary

import android.app.Application
import com.dmitriy1morozov.sample.library.EntryPoint

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        EntryPoint.initialize(this)
    }

    companion object {
        val TAG: String = MyApp::class.java.simpleName
        val APP_CENTER_SECRET = "428f4426-3f33-440f-a627-fe133d98ee93"
    }
}