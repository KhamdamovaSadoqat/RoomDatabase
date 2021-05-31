package com.example.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.database.database.WordDao

class MainViewModelFactory(private val dataSource: WordDao): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(dataSource) as T
        } else throw  IllegalArgumentException("MainViewModel class not found")
    }
}