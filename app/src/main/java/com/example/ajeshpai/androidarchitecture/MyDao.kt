package com.example.ajeshpai.androidarchitecture

import android.arch.persistence.room.*
import io.reactivex.Flowable

@Dao
interface MyDao {

    @Insert
    fun insert(item:MyPojo)

    @Query("SELECT * FROM MYPOJOTABLE")
    fun getItems(): ArrayList<MyPojo>

}