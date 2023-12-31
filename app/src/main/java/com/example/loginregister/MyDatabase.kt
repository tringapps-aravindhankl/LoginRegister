package com.example.loginregister

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserLogin::class],version=1, exportSchema = false)
abstract class MyDatabase : RoomDatabase(){

    companion object{
        private var INSTANCE: MyDatabase?=null;
        fun getInstance(context: Context): MyDatabase?{
            if(INSTANCE==null){
                synchronized(MyDatabase::class.java){
                    INSTANCE= Room.databaseBuilder(
                        context,
                        MyDatabase::class.java,
                        "UserDatabase"
                    ).build()
                }
            }
            return INSTANCE;
        }
    }

    abstract fun userDao(): UserDao
}