package com.maple.jetpackdemo.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * author: gaogq
 * time: 2019/4/10 14:09
 * description:
 */
class DataBindingViewModel :ViewModel{

     var mData:MutableLiveData<String>


    constructor(data:MutableLiveData<String>){
        this.mData = data
    }

    fun onCommit(){
        mData.value = "wow888888ow"
    }

    override fun onCleared() {
        super.onCleared()
    }
}