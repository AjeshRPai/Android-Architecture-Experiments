package com.example.ajeshpai.androidarchitecture

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

public const val TABLE_NAME="MYPOJOTABLE"
@Entity(tableName = TABLE_NAME)
 class MyPojo(){
        var name: String?=""
        @field: PrimaryKey(autoGenerate = true)
        var id:Int?=0

        constructor(name:String):this(){
                this.name=name
        }
}