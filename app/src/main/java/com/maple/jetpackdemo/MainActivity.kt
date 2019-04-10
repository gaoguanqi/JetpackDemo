package com.maple.jetpackdemo

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.maple.jetpackdemo.app.base.BaseActivity
import com.maple.jetpackdemo.app.manager.listener.OnItemClickListener
import com.maple.jetpackdemo.databinding.DataBindingActivity
import com.maple.jetpackdemo.lifecycle.LifecycleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    val list = mutableListOf("DataBinding","Lifecycle")
    var adapter:MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData(savedInstanceState)
    }

     fun initData(savedInstanceState: Bundle?) {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        adapter = MainAdapter()
        adapter?.setOnClickListener(object : OnItemClickListener {
            override fun onItemClick(pos: Int, data: Any) {
                when(pos){
                    0 -> startActivity(Intent(this@MainActivity,DataBindingActivity::class.java))
                    1 -> startActivity(Intent(this@MainActivity,LifecycleActivity::class.java))
                }
            }
        })
        recycler.adapter = adapter
        adapter?.setData(list)
    }

}
