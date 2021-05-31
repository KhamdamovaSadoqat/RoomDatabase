package com.example.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Word")
data class Word (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val english: String,
    val uzbek: String
        )