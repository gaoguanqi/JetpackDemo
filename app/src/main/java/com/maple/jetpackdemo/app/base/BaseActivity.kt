package com.maple.jetpackdemo.app.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maple.jetpackdemo.app.global.AppLifecycleObserver


/**
 * author: gaogq
 * time: 2019/4/8 13:14
 * description:
 */
abstract class BaseActivity:AppCompatActivity() {
    abstract fun layoutResID():Int
    abstract fun initData(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResID())
        lifecycle.addObserver(AppLifecycleObserver())
        initData(savedInstanceState)
    }
}