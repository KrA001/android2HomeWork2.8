package com.example.android2homework28.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android2homework28.data.models.NoteModels

//онатация рум
@Dao
interface NoteDao {
    //Получение всех даных:
    @Query("SELECT * FROM noteModel")
    fun getAll(): LiveData<List<NoteModels>>

    //Добавление:
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteModels: NoteModels)
}