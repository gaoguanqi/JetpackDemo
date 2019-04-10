package com.maple.jetpackdemo.lifecycle

import android.os.Bundle
import com.maple.jetpackdemo.R
import com.maple.jetpackdemo.app.base.BaseActivity

class LifecycleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
    }

    fun initData(savedInstanceState: Bundle?) {

    }
}
