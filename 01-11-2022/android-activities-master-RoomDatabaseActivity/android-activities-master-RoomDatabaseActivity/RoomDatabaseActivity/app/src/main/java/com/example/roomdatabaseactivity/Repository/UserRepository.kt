package com.example.roomdatabaseactivity.Repository

import androidx.lifecycle.LiveData
import com.example.roomdatabaseactivity.data.UserDao
import com.example.roomdatabaseactivity.model.User

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()
    fun addUser(user: User){
        userDao.addUser(user)
    }
    fun updateUser(user: User){
        userDao.updateUser(user)
    }
    fun deleteUser(user: User){
        userDao.deleteUser(user)
    }
    fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }

}