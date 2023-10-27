package com.example.loginregister

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "USER_DETAILS")
data class UserLogin(

    @ColumnInfo(name = "user_name")
    var username:String,

    @ColumnInfo(name = "password")
    var password:String,

    @ColumnInfo(name = "phonenumber")
    var phonenumber:String,

    @ColumnInfo(name = "user_email")
    var email:String,

    @PrimaryKey(autoGenerate = true)
    var serialno: Int=0

)