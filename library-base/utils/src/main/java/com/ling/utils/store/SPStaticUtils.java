package com.ling.utils.store;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import java.util.Map;
import java.util.Set;

/**
 * author : wangchengzhen
 * github : https://github.com/Blankj/AndroidUtilCode
 * time   : 2021/11/14
 * desc   : utils about shared preference - SP 相关
 */
public final class SPStaticUtils {

    private static SPUtils sDefaultSPUtils;

    /**
     * 设置默认 SP 实例
     * <p>
     * Set the default instance of {@link SPUtils}.
     *
     * @param spUtils The default instance of {@link SPUtils}.
     */
    public static void setDefaultSPUtils(final SPUtils spUtils) {
        sDefaultSPUtils = spUtils;
    }

    /**
     * SP 中写入 String 数据
     * <p>
     * Put the string value in sp.
     *
     * @param key   The key of sp.
     * @param value The value of sp.
     */
    public static void put(@NonNull final String key, final String value) {
        put(key, value, getDefaultSPUtils());
    }

    /**
     * SP 中写入 String 数据
     * <p>
     * Put the string value in sp.
     *
     * @param key      The key of sp.
     * @param value    The value of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     */
    public static void put(@NonNull final String key, final String value, final boolean isCommit) {
        put(key, value, isCommit, getDefaultSPUtils());
    }

    /**
     * SP 中读取 String
     * <p>
     * Return the string value in sp.
     *
     * @param key The key of sp.
     * @return the string value if sp exists or {@code ""} otherwise
     */
    public static String getString(@NonNull final String key) {
        return getString(key, getDefaultSPUtils());
    }

    /**
     * SP 中读取 String
     * <p>
     * Return the string value in sp.
     *
     * @param key          The key of sp.
     * @param defaultValue The default value if the sp doesn't exist.
     * @return the string value if sp exists or {@code defaultValue} otherwise
     */
    public static String getString(@NonNull final String key, final String defaultValue) {
        return getString(key, defaultValue, getDefaultSPUtils());
    }

    /**
     * SP 中写入 int 数据
     * <p>
     * Put the int value in sp.
     *
     * @param key   The key of sp.
     * @param value The value of sp.
     */
    public static void put(@NonNull final String key, final int value) {
        put(key, value, getDefaultSPUtils());
    }

    /**
     * SP 中写入 int 数据
     * <p>
     * Put the int value in sp.
     *
     * @param key      The key of sp.
     * @param value    The value of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     */
    public static void put(@NonNull final String key, final int value, final boolean isCommit) {
        put(key, value, isCommit, getDefaultSPUtils());
    }

    /**
     * SP 中读取 int
     * <p>
     * Return the int value in sp.
     *
     * @param key The key of sp.
     * @return the int value if sp exists or {@code -1} otherwise
     */
    public static int getInt(@NonNull final String key) {
        return getInt(key, getDefaultSPUtils());
    }

    /**
     * SP 中读取 int
     * <p>
     * Return the int value in sp.
     *
     * @param key          The key of sp.
     * @param defaultValue The default value if the sp doesn't exist.
     * @return the int value if sp exists or {@code defaultValue} otherwise
     */
    public static int getInt(@NonNull final String key, final int defaultValue) {
        return getInt(key, defaultValue, getDefaultSPUtils());
    }

    /**
     * SP 中写入 long 数据
     * <p>
     * Put the long value in sp.
     *
     * @param key   The key of sp.
     * @param value The value of sp.
     */
    public static void put(@NonNull final String key, final long value) {
        put(key, value, getDefaultSPUtils());
    }

    /**
     * SP 中写入 long 数据
     * <p>
     * Put the long value in sp.
     *
     * @param key      The key of sp.
     * @param value    The value of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     */
    public static void put(@NonNull final String key, final long value, final boolean isCommit) {
        put(key, value, isCommit, getDefaultSPUtils());
    }

    /**
     * SP 中读取 long
     * <p>
     * Return the long value in sp.
     *
     * @param key The key of sp.
     * @return the long value if sp exists or {@code -1} otherwise
     */
    public static long getLong(@NonNull final String key) {
        return getLong(key, getDefaultSPUtils());
    }

    /**
     * SP 中读取 long
     * <p>
     * Return the long value in sp.
     *
     * @param key          The key of sp.
     * @param defaultValue The default value if the sp doesn't exist.
     * @return the long value if sp exists or {@code defaultValue} otherwise
     */
    public static long getLong(@NonNull final String key, final long defaultValue) {
        return getLong(key, defaultValue, getDefaultSPUtils());
    }

    /**
     * SP 中写入 float 数据
     * <p>
     * Put the float value in sp.
     *
     * @param key   The key of sp.
     * @param value The value of sp.
     */
    public static void put(@NonNull final String key, final float value) {
        put(key, value, getDefaultSPUtils());
    }

    /**
     * SP 中写入 float 数据
     * <p>
     * Put the float value in sp.
     *
     * @param key      The key of sp.
     * @param value    The value of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     */
    public static void put(@NonNull final String key, final float value, final boolean isCommit) {
        put(key, value, isCommit, getDefaultSPUtils());
    }

    /**
     * SP 中读取 float
     * <p>
     * Return the float value in sp.
     *
     * @param key The key of sp.
     * @return the float value if sp exists or {@code -1f} otherwise
     */
    public static float getFloat(@NonNull final String key) {
        return getFloat(key, getDefaultSPUtils());
    }

    /**
     * SP 中读取 float
     * <p>
     * Return the float value in sp.
     *
     * @param key          The key of sp.
     * @param defaultValue The default value if the sp doesn't exist.
     * @return the float value if sp exists or {@code defaultValue} otherwise
     */
    public static float getFloat(@NonNull final String key, final float defaultValue) {
        return getFloat(key, defaultValue, getDefaultSPUtils());
    }

    /**
     * SP 中写入 boolean 数据
     * <p>
     * Put the boolean value in sp.
     *
     * @param key   The key of sp.
     * @param value The value of sp.
     */
    public static void put(@NonNull final String key, final boolean value) {
        put(key, value, getDefaultSPUtils());
    }

    /**
     * SP 中写入 boolean 数据
     * <p>
     * Put the boolean value in sp.
     *
     * @param key      The key of sp.
     * @param value    The value of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     */
    public static void put(@NonNull final String key, final boolean value, final boolean isCommit) {
        put(key, value, isCommit, getDefaultSPUtils());
    }

    /**
     * SP 中读取 boolean
     * <p>
     * Return the boolean value in sp.
     *
     * @param key The key of sp.
     * @return the boolean value if sp exists or {@code false} otherwise
     */
    public static boolean getBoolean(@NonNull final String key) {
        return getBoolean(key, getDefaultSPUtils());
    }

    /**
     * SP 中读取 boolean
     * <p>
     * Return the boolean value in sp.
     *
     * @param key          The key of sp.
     * @param defaultValue The default value if the sp doesn't exist.
     * @return the boolean value if sp exists or {@code defaultValue} otherwise
     */
    public static boolean getBoolean(@NonNull final String key, final boolean defaultValue) {
        return getBoolean(key, defaultValue, getDefaultSPUtils());
    }

    /**
     * Put the set of string value in sp.
     *
     * @param key   The key of sp.
     * @param value The value of sp.
     */
    public static void put(@NonNull final String key, final Set<String> value) {
        put(key, value, getDefaultSPUtils());
    }

    /**
     * Put the set of string value in sp.
     *
     * @param key      The key of sp.
     * @param value    The value of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     */
    public static void put(@NonNull final String key,
                           final Set<String> value,
                           final boolean isCommit) {
        put(key, value, isCommit, getDefaultSPUtils());
    }

    /**
     * Return the set of string value in sp.
     *
     * @param key The key of sp.
     * @return the set of string value if sp exists
     * or {@code Collections.<String>emptySet()} otherwise
     */
    public static Set<String> getStringSet(@NonNull final String key) {
        return getStringSet(key, getDefaultSPUtils());
    }

    /**
     * Return the set of string value in sp.
     *
     * @param key          The key of sp.
     * @param defaultValue The default value if the sp doesn't exist.
     * @return the set of string value if sp exists or {@code defaultValue} otherwise
     */
    public static Set<String> getStringSet(@NonNull final String key,
                                           final Set<String> defaultValue) {
        return getStringSet(key, defaultValue, getDefaultSPUtils());
    }

    /**
     * SP 中获取所有键值对
     * <p>
     * Return all values in sp.
     *
     * @return all values in sp
     */
    public static Map<String, ?> getAll() {
        return getAll(getDefaultSPUtils());
    }

    /**
     * SP 中是否存在该 key
     * <p>
     * Return whether the sp contains the preference.
     *
     * @param key The key of sp.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean contains(@NonNull final String key) {
        return contains(key, getDefaultSPUtils());
    }

    /**
     * SP 中移除该 key
     * <p>
     * Remove the preference in sp.
     *
     * @param key The key of sp.
     */
    public static void remove(@NonNull final String key) {
        remove(key, getDefaultSPUtils());
    }

    /**
     * SP 中移除该 key
     * <p>
     * Remove the preference in sp.
     *
     * @param key      The key of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     */
    public static void remove(@NonNull final String key, final boolean isCommit) {
        remove(key, isCommit, getDefaultSPUtils());
    }

    /**
     * SP 中清除所有数据
     * <p>
     * Remove all preferences in sp.
     */
    public static void clear() {
        clear(getDefaultSPUtils());
    }

    /**
     * SP 中清除所有数据
     * <p>
     * Remove all preferences in sp.
     *
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     */
    public static void clear(final boolean isCommit) {
        clear(isCommit, getDefaultSPUtils());
    }

    ///////////////////////////////////////////////////////////////////////////
    // dividing line
    ///////////////////////////////////////////////////////////////////////////

    /**
     * SP 中写入 String 数据
     * <p>
     * Put the string value in sp.
     *
     * @param key     The key of sp.
     * @param value   The value of sp.
     * @param spUtils The instance of {@link SPUtils}.
     */
    public static void put(@NonNull final String key, final String value, @NonNull final SPUtils spUtils) {
        spUtils.put(key, value);
    }

    /**
     * SP 中写入 String 数据
     * <p>
     * Put the string value in sp.
     *
     * @param key      The key of sp.
     * @param value    The value of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     * @param spUtils  The instance of {@link SPUtils}.
     */
    public static void put(@NonNull final String key,
                           final String value,
                           final boolean isCommit,
                           @NonNull final SPUtils spUtils) {
        spUtils.put(key, value, isCommit);
    }

    /**
     * SP 中读取 String
     * <p>
     * Return the string value in sp.
     *
     * @param key     The key of sp.
     * @param spUtils The instance of {@link SPUtils}.
     * @return the string value if sp exists or {@code ""} otherwise
     */
    public static String getString(@NonNull final String key, @NonNull final SPUtils spUtils) {
        return spUtils.getString(key);
    }

    /**
     * SP 中读取 String
     * <p>
     * Return the string value in sp.
     *
     * @param key          The key of sp.
     * @param defaultValue The default value if the sp doesn't exist.
     * @param spUtils      The instance of {@link SPUtils}.
     * @return the string value if sp exists or {@code defaultValue} otherwise
     */
    public static String getString(@NonNull final String key,
                                   final String defaultValue,
                                   @NonNull final SPUtils spUtils) {
        return spUtils.getString(key, defaultValue);
    }

    /**
     * SP 中写入 int 数据
     * <p>
     * Put the int value in sp.
     *
     * @param key     The key of sp.
     * @param value   The value of sp.
     * @param spUtils The instance of {@link SPUtils}.
     */
    public static void put(@NonNull final String key, final int value, @NonNull final SPUtils spUtils) {
        spUtils.put(key, value);
    }

    /**
     * SP 中写入 int 数据
     * <p>
     * Put the int value in sp.
     *
     * @param key      The key of sp.
     * @param value    The value of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     * @param spUtils  The instance of {@link SPUtils}.
     */
    public static void put(@NonNull final String key,
                           final int value,
                           final boolean isCommit,
                           @NonNull final SPUtils spUtils) {
        spUtils.put(key, value, isCommit);
    }

    /**
     * SP 中读取 int
     * <p>
     * Return the int value in sp.
     *
     * @param key     The key of sp.
     * @param spUtils The instance of {@link SPUtils}.
     * @return the int value if sp exists or {@code -1} otherwise
     */
    public static int getInt(@NonNull final String key, @NonNull final SPUtils spUtils) {
        return spUtils.getInt(key);
    }

    /**
     * SP 中读取 int
     * <p>
     * Return the int value in sp.
     *
     * @param key          The key of sp.
     * @param defaultValue The default value if the sp doesn't exist.
     * @param spUtils      The instance of {@link SPUtils}.
     * @return the int value if sp exists or {@code defaultValue} otherwise
     */
    public static int getInt(@NonNull final String key, final int defaultValue, @NonNull final SPUtils spUtils) {
        return spUtils.getInt(key, defaultValue);
    }

    /**
     * SP 中写入 long 数据
     * <p>
     * Put the long value in sp.
     *
     * @param key     The key of sp.
     * @param value   The value of sp.
     * @param spUtils The instance of {@link SPUtils}.
     */
    public static void put(@NonNull final String key, final long value, @NonNull final SPUtils spUtils) {
        spUtils.put(key, value);
    }

    /**
     * SP 中写入 long 数据
     * <p>
     * Put the long value in sp.
     *
     * @param key      The key of sp.
     * @param value    The value of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     * @param spUtils  The instance of {@link SPUtils}.
     */
    public static void put(@NonNull final String key,
                           final long value,
                           final boolean isCommit,
                           @NonNull final SPUtils spUtils) {
        spUtils.put(key, value, isCommit);
    }

    /**
     * SP 中读取 long
     * <p>
     * Return the long value in sp.
     *
     * @param key     The key of sp.
     * @param spUtils The instance of {@link SPUtils}.
     * @return the long value if sp exists or {@code -1} otherwise
     */
    public static long getLong(@NonNull final String key, @NonNull final SPUtils spUtils) {
        return spUtils.getLong(key);
    }

    /**
     * SP 中读取 long
     * <p>
     * Return the long value in sp.
     *
     * @param key          The key of sp.
     * @param defaultValue The default value if the sp doesn't exist.
     * @param spUtils      The instance of {@link SPUtils}.
     * @return the long value if sp exists or {@code defaultValue} otherwise
     */
    public static long getLong(@NonNull final String key, final long defaultValue, @NonNull final SPUtils spUtils) {
        return spUtils.getLong(key, defaultValue);
    }

    /**
     * SP 中写入 float 数据
     * <p>
     * Put the float value in sp.
     *
     * @param key     The key of sp.
     * @param value   The value of sp.
     * @param spUtils The instance of {@link SPUtils}.
     */
    public static void put(@NonNull final String key, final float value, @NonNull final SPUtils spUtils) {
        spUtils.put(key, value);
    }

    /**
     * SP 中写入 float 数据
     * <p>
     * Put the float value in sp.
     *
     * @param key      The key of sp.
     * @param value    The value of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     * @param spUtils  The instance of {@link SPUtils}.
     */
    public static void put(@NonNull final String key,
                           final float value,
                           final boolean isCommit,
                           @NonNull final SPUtils spUtils) {
        spUtils.put(key, value, isCommit);
    }

    /**
     * SP 中读取 float
     * <p>
     * Return the float value in sp.
     *
     * @param key     The key of sp.
     * @param spUtils The instance of {@link SPUtils}.
     * @return the float value if sp exists or {@code -1f} otherwise
     */
    public static float getFloat(@NonNull final String key, @NonNull final SPUtils spUtils) {
        return spUtils.getFloat(key);
    }

    /**
     * SP 中读取 float
     * <p>
     * Return the float value in sp.
     *
     * @param key          The key of sp.
     * @param defaultValue The default value if the sp doesn't exist.
     * @param spUtils      The instance of {@link SPUtils}.
     * @return the float value if sp exists or {@code defaultValue} otherwise
     */
    public static float getFloat(@NonNull final String key, final float defaultValue, @NonNull final SPUtils spUtils) {
        return spUtils.getFloat(key, defaultValue);
    }

    /**
     * SP 中写入 boolean 数据
     * <p>
     * Put the boolean value in sp.
     *
     * @param key     The key of sp.
     * @param value   The value of sp.
     * @param spUtils The instance of {@link SPUtils}.
     */
    public static void put(@NonNull final String key, final boolean value, @NonNull final SPUtils spUtils) {
        spUtils.put(key, value);
    }

    /**
     * SP 中写入 boolean 数据
     * <p>
     * Put the boolean value in sp.
     *
     * @param key      The key of sp.
     * @param value    The value of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     * @param spUtils  The instance of {@link SPUtils}.
     */
    public static void put(@NonNull final String key,
                           final boolean value,
                           final boolean isCommit,
                           @NonNull final SPUtils spUtils) {
        spUtils.put(key, value, isCommit);
    }

    /**
     * SP 中读取 boolean
     * <p>
     * Return the boolean value in sp.
     *
     * @param key     The key of sp.
     * @param spUtils The instance of {@link SPUtils}.
     * @return the boolean value if sp exists or {@code false} otherwise
     */
    public static boolean getBoolean(@NonNull final String key, @NonNull final SPUtils spUtils) {
        return spUtils.getBoolean(key);
    }

    /**
     * SP 中读取 boolean
     * <p>
     * Return the boolean value in sp.
     *
     * @param key          The key of sp.
     * @param defaultValue The default value if the sp doesn't exist.
     * @param spUtils      The instance of {@link SPUtils}.
     * @return the boolean value if sp exists or {@code defaultValue} otherwise
     */
    public static boolean getBoolean(@NonNull final String key,
                                     final boolean defaultValue,
                                     @NonNull final SPUtils spUtils) {
        return spUtils.getBoolean(key, defaultValue);
    }

    /**
     * Put the set of string value in sp.
     *
     * @param key     The key of sp.
     * @param value   The value of sp.
     * @param spUtils The instance of {@link SPUtils}.
     */
    public static void put(@NonNull final String key, final Set<String> value, @NonNull final SPUtils spUtils) {
        spUtils.put(key, value);
    }

    /**
     * Put the set of string value in sp.
     *
     * @param key      The key of sp.
     * @param value    The value of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     * @param spUtils  The instance of {@link SPUtils}.
     */
    public static void put(@NonNull final String key,
                           final Set<String> value,
                           final boolean isCommit,
                           @NonNull final SPUtils spUtils) {
        spUtils.put(key, value, isCommit);
    }

    /**
     * Return the set of string value in sp.
     *
     * @param key     The key of sp.
     * @param spUtils The instance of {@link SPUtils}.
     * @return the set of string value if sp exists
     * or {@code Collections.<String>emptySet()} otherwise
     */
    public static Set<String> getStringSet(@NonNull final String key, @NonNull final SPUtils spUtils) {
        return spUtils.getStringSet(key);
    }

    /**
     * Return the set of string value in sp.
     *
     * @param key          The key of sp.
     * @param defaultValue The default value if the sp doesn't exist.
     * @param spUtils      The instance of {@link SPUtils}.
     * @return the set of string value if sp exists or {@code defaultValue} otherwise
     */
    public static Set<String> getStringSet(@NonNull final String key,
                                           final Set<String> defaultValue,
                                           @NonNull final SPUtils spUtils) {
        return spUtils.getStringSet(key, defaultValue);
    }

    /**
     * SP 中获取所有键值对
     * <p>
     * Return all values in sp.
     *
     * @param spUtils The instance of {@link SPUtils}.
     * @return all values in sp
     */
    public static Map<String, ?> getAll(@NonNull final SPUtils spUtils) {
        return spUtils.getAll();
    }

    /**
     * SP 中是否存在该 key
     * <p>
     * Return whether the sp contains the preference.
     *
     * @param key     The key of sp.
     * @param spUtils The instance of {@link SPUtils}.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean contains(@NonNull final String key, @NonNull final SPUtils spUtils) {
        return spUtils.contains(key);
    }

    /**
     * SP 中移除该 key
     * <p>
     * Remove the preference in sp.
     *
     * @param key     The key of sp.
     * @param spUtils The instance of {@link SPUtils}.
     */
    public static void remove(@NonNull final String key, @NonNull final SPUtils spUtils) {
        spUtils.remove(key);
    }

    /**
     * SP 中移除该 key
     * <p>
     * Remove the preference in sp.
     *
     * @param key      The key of sp.
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     * @param spUtils  The instance of {@link SPUtils}.
     */
    public static void remove(@NonNull final String key, final boolean isCommit, @NonNull final SPUtils spUtils) {
        spUtils.remove(key, isCommit);
    }

    /**
     * SP 中清除所有数据
     * <p>
     * Remove all preferences in sp.
     *
     * @param spUtils The instance of {@link SPUtils}.
     */
    public static void clear(@NonNull final SPUtils spUtils) {
        spUtils.clear();
    }

    /**
     * SP 中清除所有数据
     * <p>
     * Remove all preferences in sp.
     *
     * @param isCommit True to use {@link SharedPreferences.Editor#commit()},
     *                 false to use {@link SharedPreferences.Editor#apply()}
     * @param spUtils  The instance of {@link SPUtils}.
     */
    public static void clear(final boolean isCommit, @NonNull final SPUtils spUtils) {
        spUtils.clear(isCommit);
    }

    private static SPUtils getDefaultSPUtils() {
        return sDefaultSPUtils != null ? sDefaultSPUtils : SPUtils.getInstance();
    }
}
