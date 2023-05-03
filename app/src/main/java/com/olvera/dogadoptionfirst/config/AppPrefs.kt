package com.olvera.dogadoptionfirst.config

import android.content.Context
import android.content.SharedPreferences

class AppPrefs(context: Context) {

    private var prefs: SharedPreferences
    private var prefsEditor: SharedPreferences.Editor

    init {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefsEditor = prefs.edit()
    }

    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        prefsEditor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
        prefsEditor.commit()
    }

    fun isFirstTimeLaunch(): Boolean = prefs.getBoolean(IS_FIRST_TIME_LAUNCH, true)
    fun rememberUser(email: String, password: String) {
        prefsEditor.putString("email", email)
        prefsEditor.putString("password", password)
        prefsEditor.commit()

    }

    fun setUserName(name: String) {
        prefsEditor.putString("name", name)
        prefsEditor.commit()
    }

    fun getUserName(): String? {
        return prefs.getString("name", "")
    }

    fun setEmail(email: String) {
        prefsEditor.putString("email", email)
        prefsEditor.commit()
    }

    fun getEmail(): String? {
        return prefs.getString("email", "")
    }
    companion object {
        private const val PREF_NAME = "email"
        private const val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
    }

}