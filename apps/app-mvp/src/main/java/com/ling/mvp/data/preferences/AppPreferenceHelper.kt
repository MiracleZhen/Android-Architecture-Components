package com.ling.mvp.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.ling.mvp.app.AppConstants
import com.ling.mvp.di.PreferenceInfo
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : 本地轻量级配置数据实现类
 */
class AppPreferenceHelper @Inject constructor(
    context: Context,
    @PreferenceInfo private val prefFileName: String)
    : PreferenceHelper {

    companion object {
        private const val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private const val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private const val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private const val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
        private const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getCurrentUserLoggedInMode(): Int =
        prefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE, AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type)

    override fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode) {
        prefs.edit { putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.type) }
    }

    override fun getCurrentUserId(): Long? {
        return when (val userId = prefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX)) {
            AppConstants.NULL_INDEX -> null
            else -> userId
        }
    }

    override fun setCurrentUserId(userId: Long?) {
        val id = userId ?: AppConstants.NULL_INDEX
        prefs.edit { putLong(PREF_KEY_CURRENT_USER_ID, id) }
    }

    override fun getCurrentUserName(): String? = prefs.getString(PREF_KEY_CURRENT_USER_NAME, "ABC")

    override fun setCurrentUserName(userName: String?) =
        prefs.edit { putString(PREF_KEY_CURRENT_USER_NAME, userName) }

    override fun getCurrentUserEmail(): String? =
        prefs.getString(PREF_KEY_CURRENT_USER_EMAIL, "abc@gmail.com")

    override fun setCurrentUserEmail(email: String?) =
        prefs.edit { putString(PREF_KEY_CURRENT_USER_EMAIL, email) }

    override fun getAccessToken(): String? = prefs.getString(PREF_KEY_ACCESS_TOKEN, "")

    override fun setAccessToken(accessToken: String?) =
        prefs.edit { putString(PREF_KEY_ACCESS_TOKEN, accessToken) }
}
