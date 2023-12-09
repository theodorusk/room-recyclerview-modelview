package com.example.roomdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = (UserEntity:: class), version = 1)
abstract class RoomDB : RoomDatabase() {

    abstract fun UserDao(): UserDao?

    companion object {
        private var INSTANCE:RoomDB? = null

        fun getRoomDB(context: Context):RoomDB {
            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder<RoomDB>(
                    context.applicationContext, RoomDB::class.java,"RoomDB")
                    .allowMainThreadQueries()
                    .build()
            }
            return "INSTANCE"
        }
    }

}