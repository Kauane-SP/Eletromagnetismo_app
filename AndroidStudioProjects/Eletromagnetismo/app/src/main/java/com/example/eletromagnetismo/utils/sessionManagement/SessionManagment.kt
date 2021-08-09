package com.example.eletromagnetismo.utils.sessionManagement

import android.content.Context
import com.example.eletromagnetismo.utils.preferences.AppPreferences

class SessionManagment(val context: Context) {
    companion object{
        const val KEY_SESSION_INFO = "SessionInfo"
        const val KEY_USER_NAME = "UserName"
    }

    private val mSharedPreferences = AppPreferences(context)

    fun initializeSession(nome: String){
        mSharedPreferences.storeSessionInfo(KEY_SESSION_INFO, true)
        mSharedPreferences.storeString(KEY_USER_NAME, nome)
    }

    fun getInfoUser():String {
        return mSharedPreferences.getString(KEY_USER_NAME)
    }

    fun getInfoSession():Boolean{
        return mSharedPreferences.getSessionInfo(KEY_SESSION_INFO)
    }
}