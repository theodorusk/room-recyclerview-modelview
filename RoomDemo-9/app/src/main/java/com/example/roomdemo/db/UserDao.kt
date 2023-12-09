package com.example.roomdemo.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Query("SELECT * FROM userinfo ORDER BY id DESC")
    fun getAllUserInfo() : List<UserEntity>?

    @Insert
    fun inserUser(ser : UserEntity?)

    @Delete
    fun DeleteUser(user : UserEntity?)

    @Update
    fun UpdateUser(user : UserEntity?)



}