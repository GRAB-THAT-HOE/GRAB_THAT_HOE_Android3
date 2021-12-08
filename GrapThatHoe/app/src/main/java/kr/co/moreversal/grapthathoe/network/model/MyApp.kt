package kr.co.moreversal.grapthathoe.network.model

import android.app.Application

class MyApp : Application() {
    companion object {
        lateinit var instance: MyApp
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}