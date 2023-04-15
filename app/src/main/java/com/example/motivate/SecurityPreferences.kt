package com.example.motivate

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {
    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeUserName(key: String, str: String){
        security.edit().putString(key, str).apply()
    }
    fun getUserName(key: String): String{
        return security.getString(key, "") ?: "Estranho"
    }
}