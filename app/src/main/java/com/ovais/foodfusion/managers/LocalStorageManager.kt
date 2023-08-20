package com.ovais.foodfusion.managers

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface LocalStorageManager {
    fun putString(key: String, value: String)
    fun getString(key: String): String?
    fun remove(key: String)
    fun putBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean
}

class DefaultLocalStorageManager @Inject constructor(
    @ApplicationContext private val context: Context
) : LocalStorageManager {

    private val fileName by lazy {
        "food_fusion_pref"
    }
    private val masterKey by lazy {
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()
    }
    private val sharedPreferences by lazy {
        EncryptedSharedPreferences.create(
            context,
            fileName,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    override fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    override fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    override fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    override fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }
}