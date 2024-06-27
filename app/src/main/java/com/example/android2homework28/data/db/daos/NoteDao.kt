package com.example.android2homework28.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.android2homework28.data.models.NoteModels

//онатация рум
@Dao
interface NoteDao {
    //Получение всех даных:
    @Query("SELECT * FROM noteModel")
    fun getAll(): LiveData<List<NoteModels>>

    //Добавление данных:
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteModels: NoteModels)

    // удаление данных
    @Delete
    fun deleteNote(noteModels: NoteModels)

    // Изменение данных
    @Update
    fun updateNote(noteModels: NoteModels)

    // доствовать по айди чтобы изменять
    @Query("SELECT * FROM noteModel WHERE id = :id")
    fun getNoteById(id: Int):NoteModels?
}