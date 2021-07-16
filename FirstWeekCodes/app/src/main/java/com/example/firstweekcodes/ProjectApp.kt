package com.example.firstweekcodes

import android.app.Application
import android.util.Log

class ProjectApp: Application() {


    override fun onCreate() {
        super.onCreate()
        Log.v("ProjectApp","Application is created.")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.v("ProjectApp","Application is terminated.")
    }
}