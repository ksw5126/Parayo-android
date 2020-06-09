package com.example.parayo

import android.app.Application

/**
 * Created by KSW on 2020-06-09
 */

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance : App
    }
}