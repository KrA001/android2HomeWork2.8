package com.example.android2homework28.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {
    private lateinit var sharedPreference: SharedPreferences

    //единицы тоесть вызвать а потом
    fun unit(context: Context){
        sharedPreference = context.getSharedPreferences("shared" , Context.MODE_PRIVATE)
    }

    //сохранение стринга
    var text: String?
        get() = sharedPreference.getString("text", "")
        set(value) = sharedPreference.edit().putString("text", value)!!.apply()

    //сохранение булиан
    var isOnBoarShow:Boolean
        get() = sharedPreference.getBoolean("board",false)
        set(value) = sharedPreference.edit().putBoolean("board", value).apply()

    //сохранение булиан
    var saveBoolean
        set(value) = sharedPreference?.edit()?.putBoolean("Bool", value!!)?.apply()!!
        get() = sharedPreference?.getBoolean("Bool", false)
}