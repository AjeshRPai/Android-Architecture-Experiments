package com.example.ajeshpai.androidarchitecture

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import io.reactivex.Flowable

@Dao
interface MyDao {

    @Insert
    fun insert(item:MyPojo)

    @Query("SELECT * FROM MYPOJOTABLE")
    fun getItems(): LiveData<List<MyPojo>>

}