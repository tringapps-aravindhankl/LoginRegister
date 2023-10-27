package com.example.loginregister

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert()
    fun insertData(user:UserLogin)

    @Query("SELECT user_email FROM USER_DETAILS where user_email =:email")
    fun checkEmail(email: String): String


}