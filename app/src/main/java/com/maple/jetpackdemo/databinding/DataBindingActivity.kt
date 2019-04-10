package com.maple.jetpackdemo.databinding

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.maple.jetpackdemo.R
import com.maple.jetpackdemo.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_data_binding.*

class DataBindingActivity : BaseActivity() {
    lateinit var binding:ActivityDataBindingBinding
    lateinit var viewModel: DataBindingViewModel
    //var data:MutableLiveData<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding)
         binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
        initData(savedInstanceState)

        btn_test.setOnClickListener {
            binding.data = "测试"
            Toast.makeText(this@DataBindingActivity,"点击测试",Toast.LENGTH_SHORT).show()
        }
    }

     fun initData(savedInstanceState: Bundle?) {
         //data = MutableLiveData()
        // data?.value = "111"
         binding.data = "准备"
    }

}
