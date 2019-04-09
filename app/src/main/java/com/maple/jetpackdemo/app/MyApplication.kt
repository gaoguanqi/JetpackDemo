package com.maple.jetpackdemo.app

import android.app.Application

/**
 * author: gaogq
 * time: 2019/4/8 13:17
 * description:
 */
class MyApplication:Application() {
    companion object {
        @JvmStatic lateinit var instance:MyApplication
        private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}