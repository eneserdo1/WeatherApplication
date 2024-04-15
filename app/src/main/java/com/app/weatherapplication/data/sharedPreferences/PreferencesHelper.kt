package com.app.weatherapplication.data.sharedPreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class PreferencesHelper private constructor(context: Context) {

    private val mPreferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    private val mEditor: SharedPreferences.Editor = mPreferences.edit()

    companion object {

        private var instance: PreferencesHelper? = null


        const val SELECTED_CITY_NAME: String = "SELECTED_CITY_NAME"


        fun getInstance(context: Context): PreferencesHelper {
            if (instance == null)
                instance = PreferencesHelper(context)
            return instance as PreferencesHelper
        }
    }

    var selectedCity: String
        get() = mPreferences.getString(SELECTED_CITY_NAME, "")!!
        set(value) {
            mEditor.putString(SELECTED_CITY_NAME, value)
            mEditor.commit()
        }


    fun clear() {
        mEditor.clear()
        mEditor.commit()
    }


}