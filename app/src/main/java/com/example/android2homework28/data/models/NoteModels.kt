package com.example.android2homework28.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

//онатация рум
@Entity(tableName = "noteModel")
data class NoteModels(
    val title: String,
    val description: String,
    val color: String,
    val data: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
