package com.maple.jetpackdemo

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.maple.jetpackdemo.app.base.BaseActivity
import com.maple.jetpackdemo.app.manager.listener.OnItemClickListener
import com.maple.jetpackdemo.databinding.DataBindingActivity
import com.maple.jetpackdemo.lifecycle.LifecycleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    val list = mutableListOf("db","lf")
    var adapter:MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData(savedInstanceState)
    }

     fun initData(savedInstanceState: Bundle?) {
         refreshLayout.setColorSchemeColors(ContextCompat.getColor(this@MainActivity,R.color.colorAccent))
         refreshLayout.setOnRefreshListener{onRefresh()}
        recycler.layoutManager = LinearLayoutManager(this@MainActivity)
         val decoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
         decoration.setDrawable(this@MainActivity.resources.getDrawable(R.drawable.divider_list_line))
       // recycler.addItemDecoration(decoration)
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

    private fun onRefresh() {
        hideRefresh()
    }


    private fun hideRefresh(){
        refreshLayout?.isRefreshing = false
    }

}
