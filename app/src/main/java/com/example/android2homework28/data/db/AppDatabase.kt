package com.example.android2homework28.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android2homework28.data.db.daos.NoteDao
import com.example.android2homework28.data.models.NoteModels

//тут меняем версию базы дата и добавляем наши таблицы:
@Database(entities = [NoteModels::class], version = 2)
abstract class AppDatabase: RoomDatabase() {

    abstract fun noteDao():NoteDao
}