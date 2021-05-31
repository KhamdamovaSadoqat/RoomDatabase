package com.example.database.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.model.Word

@Dao
interface WordDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Word)

    @Query("Select * from `Word` where english = :word")
    fun getWord(word: String): LiveData<Word>

//    @Query("Update Student set techId = :techId where id = :id")
//    fun updateStudentValue(id: Int, techId: Int)

}