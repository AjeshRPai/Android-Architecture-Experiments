package com.example.ajeshpai.androidarchitecture

import android.content.Context


object Injection {

    fun provideDataSource(context: Context):MyDao{
        val database=AppDatabase.getInstance(context)
        return database.myDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val dataSource = provideDataSource(context)
        return ViewModelFactory(dataSource)
    }



}