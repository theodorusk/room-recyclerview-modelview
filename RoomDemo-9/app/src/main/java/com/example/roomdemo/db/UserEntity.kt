package com.example.roomdemo.db

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Userinfo")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id : Int = 0,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("email") val email: String


)
