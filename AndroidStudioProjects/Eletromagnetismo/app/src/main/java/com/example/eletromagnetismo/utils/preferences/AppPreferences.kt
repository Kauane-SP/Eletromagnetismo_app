package com.example.eletromagnetismo.utils.preferences

import android.content.Context

class AppPreferences(context: Context) {
    private val mSharedPreferences = context.getSharedPreferences("APP", Context.MODE_PRIVATE)

    fun storeString(key: String, Value: String){
        mSharedPreferences.edit().putString(key,Value).apply()
    }

    fun getString(key: String): String{
        return mSharedPreferences.getString(key, "") ?: ""
    }

    fun storeSessionInfo(key: String, Value: Boolean){
        mSharedPreferences.edit().putBoolean(key,Value).apply()
    }

    fun getSessionInfo(key: String): Boolean{
        return mSharedPreferences.getBoolean(key, false) ?: false
    }
}