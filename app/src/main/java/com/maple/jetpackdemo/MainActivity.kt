package com.maple.jetpackdemo

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.maple.jetpackdemo.app.base.BaseActivity
import com.maple.jetpackdemo.app.manager.listener.OnItemClickListener
import com.maple.jetpackdemo.lifecycle.LifecycleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    val list = mutableListOf("Lifecycle","22222","22222222")
    var adapter:MainAdapter? = null

    override fun layoutResID(): Int = R.layout.activity_main

    override fun initData(savedInstanceState: Bundle?) {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        adapter = MainAdapter()
        adapter?.setOnClickListener(object : OnItemClickListener {
            override fun onItemClick(pos: Int, data: Any) {
                when(pos){
                    0 -> startActivity(Intent(this@MainActivity,LifecycleActivity::class.java))
                }
            }
        })
        recycler.adapter = adapter
        adapter?.setData(list)
    }

}
