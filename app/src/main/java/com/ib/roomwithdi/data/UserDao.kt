package com.ib.roomwithdi.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addName(user: User)

    @Query("SELECT * FROM user_table ")
    fun getName(): LiveData<List<User>>
}