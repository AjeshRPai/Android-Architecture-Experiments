package com.example.ajeshpai.androidarchitecture

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(MyPojo::class), version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun myDao(): MyDao


    companion object {
        @Volatile private var INSTANCE:AppDatabase?=null

        fun getInstance(context:Context):AppDatabase=
                INSTANCE?: synchronized(this){
                    INSTANCE?: buildDatabase(context).also { INSTANCE=it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "Sample.db")
                        .build()
    }

}