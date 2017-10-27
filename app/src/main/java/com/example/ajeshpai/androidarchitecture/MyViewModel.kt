package com.example.ajeshpai.androidarchitecture

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.functions.Action
import io.reactivex.internal.operators.completable.CompletableFromAction


class MyViewModel(private val  dao: MyDao): ViewModel() {




    private  var data:LiveData<List<MyPojo>>?=null


    fun add(pojo: MyPojo): CompletableFromAction {
        return CompletableFromAction(Action {
            dao.insert(pojo)
        })
    }




    fun getAll(): LiveData<List<MyPojo>> {
        if(data==null)
            data=dao.getItems()
        return data!!
    }


}
