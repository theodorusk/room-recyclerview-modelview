package com.example.roomdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.roomdemo.db.RoomDB
import com.example.roomdemo.db.UserEntity

class MainActivityViewModel(app : Application): AndroidViewModel(app) {
    lateinit var allUsers : MutableLiveData<List<UserEntity>>

    init {

        allUsers = MutableLiveData()
    }

    fun getAllUsersObservers(): MutableLiveData<List<UserEntity>> {
        return allUsers
    }

    fun getAllUsers() {
       val UserDao = RoomDB.getRoomDB((getApplication()))?.UserDao()
        val list = UserDao?.getAllUserInfo()

        allUsers.postValue(list)
    }

    fun inserUserInfo(entity: UserEntity) {
        val UserDao = RoomDB.getRoomDB(getApplication())?.UserDao()
        UserDao?.inserUser(entity)
        getAllUsers()
    }

    fun updateUserInfo(entity: UserEntity) {
        val UserDao = RoomDB.getRoomDB(getApplication())?.UserDao()
        UserDao?.UpdateUser(entity)
        getAllUsers()
    }

    fun deleteUserInfo(entity: UserEntity) {
        val UserDao = RoomDB.getRoomDB(getApplication())?.UserDao()
        UserDao?.DeleteUser(entity)
        getAllUsers()
    }


}