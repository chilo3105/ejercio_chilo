package com.example.proyecto.database


import android.app.Application

class MyApp: Application() {

    override fun onCreate() {
        DatabaseManager.instance.initializeDb(applicationContext)
        super.onCreate()
    }

}