package com.ib.roomwithdi.repository

import androidx.lifecycle.LiveData
import com.ib.roomwithdi.data.User
import com.ib.roomwithdi.data.UserDao

class Repository(private val userDao: UserDao) {
    val getName: LiveData<List<User>> = userDao.getName()
    suspend fun addName(user: User){
userDao.addName(user)
    }
}