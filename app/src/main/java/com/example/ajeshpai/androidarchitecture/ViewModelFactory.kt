package com.example.ajeshpai.androidarchitecture

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException


class ViewModelFactory(private val datasource:MyDao):ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MyViewModel::class.java)){
            return MyViewModel(datasource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}