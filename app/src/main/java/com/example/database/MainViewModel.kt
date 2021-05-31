package com.example.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.database.WordDao
import com.example.database.model.Word
import com.example.database.repository.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(dataSource: WordDao): ViewModel() {

    private lateinit var wordList: LiveData<Word>
    private val wordRepository = WordRepository(dataSource)


    fun getWord(word: String): LiveData<Word> {
        wordList =  wordRepository.getWord(word)
        return wordList
    }

    fun setWord(word: Word){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                wordRepository.insertWord(word)
            }
        }
    }
}