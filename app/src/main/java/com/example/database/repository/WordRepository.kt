package com.example.database.repository

import androidx.lifecycle.LiveData
import com.example.database.database.WordDao
import com.example.database.model.Word

class WordRepository(private  val dataSource: WordDao) {

    suspend fun insertWord(word: Word){
        dataSource.insertWord(word)
    }

    fun getWord(word: String): LiveData<Word>{
        return  dataSource.getWord(word)
    }

}