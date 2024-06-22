package com.example.android2homework28

import android.app.Application
import androidx.room.Room
import com.example.android2homework28.data.db.AppDatabase
import com.example.android2homework28.utils.PreferenceHelper

class App: Application() {

    companion object{
        var appDatabase: AppDatabase? = null
    }
    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.unit(this)
        getInstance()
    }

     fun getInstance(): AppDatabase? {
        if (appDatabase == null) {
            appDatabase = applicationContext?.let {context->
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "note_database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }
        return appDatabase
    }
}