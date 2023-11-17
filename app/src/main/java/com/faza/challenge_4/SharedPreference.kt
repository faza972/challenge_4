package com.faza.challenge_4

import android.content.Context
import android.content.SharedPreferences

class SharedPreference (context: Context){
    companion object{
        private const val USER = "User SharePref"
        private const val KEY = "Key SharePref"
    }
    private val preferences: SharedPreferences = context.getSharedPreferences(USER, 0)
    fun getPreference () : Boolean {
        return preferences.getBoolean(KEY, true)
    }

    fun savePrefLayout(isGrid: Boolean){
        preferences.edit().putBoolean(KEY, isGrid).apply()
    }

    fun setPreference (key: String, value: Boolean) {
        val editor: SharedPreferences.Editor = preferences.edit()
        with(editor) {
            putBoolean(key, value)
            apply()
            commit()
        }
    }
}
