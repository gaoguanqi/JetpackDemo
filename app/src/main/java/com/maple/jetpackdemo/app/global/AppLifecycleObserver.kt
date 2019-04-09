package com.maple.jetpackdemo.app.global

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.maple.jetpackdemo.utils.LogUtils

/**
 * author: gaogq
 * time: 2019/4/8 13:41
 * description:
 */
class AppLifecycleObserver: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        LogUtils.logGGQ("onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        LogUtils.logGGQ("onDestroy")
    }

}