package com.example.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.database.model.Word

@Database(entities = [Word::class], version = 1, exportSchema = true)
abstract class RoomDatabase: androidx.room.RoomDatabase() {
    abstract val wordDao: WordDao

    companion object{
        private var INSTANCE: RoomDatabase? = null

        fun getDatabase(context: Context): RoomDatabase{
            if(INSTANCE != null){
                return  INSTANCE!!
            }
            synchronized(this){
                val database = Room
                    .databaseBuilder(context, RoomDatabase::class.java, "Translate")
                    .build()

                INSTANCE = database
                return INSTANCE!!
            }
        }
    }
}