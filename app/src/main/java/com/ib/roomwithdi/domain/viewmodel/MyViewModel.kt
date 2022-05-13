package com.ib.roomwithdi.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ib.roomwithdi.data.User
import com.ib.roomwithdi.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor (private var repository: Repository) : ViewModel() {


    val getName: LiveData<List<User>> = repository.getName

    fun addName(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addName(user)
        }
    }

}