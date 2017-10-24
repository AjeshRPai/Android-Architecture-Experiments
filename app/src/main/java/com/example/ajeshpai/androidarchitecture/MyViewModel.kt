package com.example.ajeshpai.androidarchitecture

import android.arch.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer



class MyViewModel(private val  dao: MyDao): ViewModel() {



    fun addName(pojo: MyPojo){
        dao.insert(pojo)
    }

    fun getAll(): Flowable<ArrayList<MyPojo>> {
        return Flowable.just(dao.getItems())
    }


}
