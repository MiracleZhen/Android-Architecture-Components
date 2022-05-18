package com.ling.utils.cache;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * author : wangchengzhen
 * github : https://github.com/Blankj/AndroidUtilCode
 * time   : 2021/11/12
 * desc   : utils about disk cache - 磁盘缓存相关
 */
public final class CacheDiskStaticUtils {

    private static CacheDiskUtils sDefaultCacheDiskUtils;

    /**
     * 设置默认磁盘缓存实例
     * <p>
     * Set the default instance of {@link CacheDiskUtils}.
     *
     * @param cacheDiskUtils The default instance of {@link CacheDiskUtils}.
     */
    public static void setDefaultCacheDiskUtils(@Nullable final CacheDiskUtils cacheDiskUtils) {
        sDefaultCacheDiskUtils = cacheDiskUtils;
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put bytes in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final byte[] value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put bytes in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key, @Nullable final byte[] value, final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取字节数组
     * <p>
     * Return the bytes in cache.
     *
     * @param key The key of cache.
     * @return the bytes if cache exists or null otherwise
     */
    public static byte[] getBytes(@NonNull final String key) {
        return getBytes(key, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取字节数组
     * <p>
     * Return the bytes in cache.
     *
     * @param key          The key of cache.
     * @param defaultValue The default value if the cache doesn't exist.
     * @return the bytes if cache exists or defaultValue otherwise
     */
    public static byte[] getBytes(@NonNull final String key, @Nullable final byte[] defaultValue) {
        return getBytes(key, defaultValue, getDefaultCacheDiskUtils());
    }

    ///////////////////////////////////////////////////////////////////////////
    // about String
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put string value in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final String value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put string value in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key, @Nullable final String value, final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 String
     * <p>
     * Return the string value in cache.
     *
     * @param key The key of cache.
     * @return the string value if cache exists or null otherwise
     */
    public static String getString(@NonNull final String key) {
        return getString(key, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 String
     * <p>
     * Return the string value in cache.
     *
     * @param key          The key of cache.
     * @param defaultValue The default value if the cache doesn't exist.
     * @return the string value if cache exists or defaultValue otherwise
     */
    public static String getString(@NonNull final String key, @Nullable final String defaultValue) {
        return getString(key, defaultValue, getDefaultCacheDiskUtils());
    }

    ///////////////////////////////////////////////////////////////////////////
    // about JSONObject
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put JSONObject in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final JSONObject value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put JSONObject in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key,
                           @Nullable final JSONObject value,
                           final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 JSONObject
     * <p>
     * Return the JSONObject in cache.
     *
     * @param key The key of cache.
     * @return the JSONObject if cache exists or null otherwise
     */
    public static JSONObject getJSONObject(@NonNull final String key) {
        return getJSONObject(key, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 JSONObject
     * <p>
     * Return the JSONObject in cache.
     *
     * @param key          The key of cache.
     * @param defaultValue The default value if the cache doesn't exist.
     * @return the JSONObject if cache exists or defaultValue otherwise
     */
    public static JSONObject getJSONObject(@NonNull final String key, @Nullable final JSONObject defaultValue) {
        return getJSONObject(key, defaultValue, getDefaultCacheDiskUtils());
    }

    ///////////////////////////////////////////////////////////////////////////
    // about JSONArray
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put JSONArray in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final JSONArray value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put JSONArray in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key, @Nullable final JSONArray value, final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 JSONArray
     * <p>
     * Return the JSONArray in cache.
     *
     * @param key The key of cache.
     * @return the JSONArray if cache exists or null otherwise
     */
    public static JSONArray getJSONArray(@NonNull final String key) {
        return getJSONArray(key, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 JSONArray
     * <p>
     * Return the JSONArray in cache.
     *
     * @param key          The key of cache.
     * @param defaultValue The default value if the cache doesn't exist.
     * @return the JSONArray if cache exists or defaultValue otherwise
     */
    public static JSONArray getJSONArray(@NonNull final String key, @Nullable final JSONArray defaultValue) {
        return getJSONArray(key, defaultValue, getDefaultCacheDiskUtils());
    }

    ///////////////////////////////////////////////////////////////////////////
    // about Bitmap
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put bitmap in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final Bitmap value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put bitmap in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key, @Nullable final Bitmap value, final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 Bitmap
     * <p>
     * Return the bitmap in cache.
     *
     * @param key The key of cache.
     * @return the bitmap if cache exists or null otherwise
     */
    public static Bitmap getBitmap(@NonNull final String key) {
        return getBitmap(key, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 Bitmap
     * <p>
     * Return the bitmap in cache.
     *
     * @param key          The key of cache.
     * @param defaultValue The default value if the cache doesn't exist.
     * @return the bitmap if cache exists or defaultValue otherwise
     */
    public static Bitmap getBitmap(@NonNull final String key, @Nullable final Bitmap defaultValue) {
        return getBitmap(key, defaultValue, getDefaultCacheDiskUtils());
    }

    ///////////////////////////////////////////////////////////////////////////
    // about Drawable
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put drawable in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final Drawable value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put drawable in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key, @Nullable final Drawable value, final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 Drawable
     * <p>
     * Return the drawable in cache.
     *
     * @param key The key of cache.
     * @return the drawable if cache exists or null otherwise
     */
    public static Drawable getDrawable(@NonNull final String key) {
        return getDrawable(key, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 Drawable
     * <p>
     * Return the drawable in cache.
     *
     * @param key          The key of cache.
     * @param defaultValue The default value if the cache doesn't exist.
     * @return the drawable if cache exists or defaultValue otherwise
     */
    public static Drawable getDrawable(@NonNull final String key, final @Nullable Drawable defaultValue) {
        return getDrawable(key, defaultValue, getDefaultCacheDiskUtils());
    }

    ///////////////////////////////////////////////////////////////////////////
    // about Parcelable
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put parcelable in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final Parcelable value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put parcelable in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key, @Nullable final Parcelable value, final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 Parcelable
     * <p>
     * Return the parcelable in cache.
     *
     * @param key     The key of cache.
     * @param creator The creator.
     * @param <T>     The value type.
     * @return the parcelable if cache exists or null otherwise
     */
    public static <T> T getParcelable(@NonNull final String key,
                                      @NonNull final Parcelable.Creator<T> creator) {
        return getParcelable(key, creator, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 Parcelable
     * <p>
     * Return the parcelable in cache.
     *
     * @param key          The key of cache.
     * @param creator      The creator.
     * @param defaultValue The default value if the cache doesn't exist.
     * @param <T>          The value type.
     * @return the parcelable if cache exists or defaultValue otherwise
     */
    public static <T> T getParcelable(@NonNull final String key,
                                      @NonNull final Parcelable.Creator<T> creator,
                                      @Nullable final T defaultValue) {
        return getParcelable(key, creator, defaultValue, getDefaultCacheDiskUtils());
    }

    ///////////////////////////////////////////////////////////////////////////
    // about Serializable
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put serializable in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final Serializable value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put serializable in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key, @Nullable final Serializable value, final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 Serializable
     * <p>
     * Return the serializable in cache.
     *
     * @param key The key of cache.
     * @return the bitmap if cache exists or null otherwise
     */
    public static Object getSerializable(@NonNull final String key) {
        return getSerializable(key, getDefaultCacheDiskUtils());
    }

    /**
     * 缓存中读取 Serializable
     * <p>
     * Return the serializable in cache.
     *
     * @param key          The key of cache.
     * @param defaultValue The default value if the cache doesn't exist.
     * @return the bitmap if cache exists or defaultValue otherwise
     */
    public static Object getSerializable(@NonNull final String key, @Nullable final Object defaultValue) {
        return getSerializable(key, defaultValue, getDefaultCacheDiskUtils());
    }

    /**
     * 获取缓存大小
     * <p>
     * Return the size of cache, in bytes.
     *
     * @return the size of cache, in bytes
     */
    public static long getCacheSize() {
        return getCacheSize(getDefaultCacheDiskUtils());
    }

    /**
     * 获取缓存个数
     * <p>
     * Return the count of cache.
     *
     * @return the count of cache
     */
    public static int getCacheCount() {
        return getCacheCount(getDefaultCacheDiskUtils());
    }

    /**
     * 根据键值移除缓存
     * <p>
     * Remove the cache by key.
     *
     * @param key The key of cache.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean remove(@NonNull final String key) {
        return remove(key, getDefaultCacheDiskUtils());
    }

    /**
     * 清除所有缓存
     * <p>
     * Clear all of the cache.
     *
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean clear() {
        return clear(getDefaultCacheDiskUtils());
    }

    ///////////////////////////////////////////////////////////////////////////
    // dividing line
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put bytes in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final byte[] value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put bytes in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final byte[] value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取字节数组
     * <p>
     * Return the bytes in cache.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the bytes if cache exists or null otherwise
     */
    public static byte[] getBytes(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getBytes(key);
    }

    /**
     * 缓存中读取字节数组
     * <p>
     * Return the bytes in cache.
     *
     * @param key            The key of cache.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the bytes if cache exists or defaultValue otherwise
     */
    public static byte[] getBytes(@NonNull final String key,
                                  @Nullable final byte[] defaultValue,
                                  @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getBytes(key, defaultValue);
    }

    ///////////////////////////////////////////////////////////////////////////
    // about String
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put string value in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final String value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put string value in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final String value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 String
     * <p>
     * Return the string value in cache.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the string value if cache exists or null otherwise
     */
    public static String getString(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getString(key);
    }

    /**
     * 缓存中读取 String
     * <p>
     * Return the string value in cache.
     *
     * @param key            The key of cache.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the string value if cache exists or defaultValue otherwise
     */
    public static String getString(@NonNull final String key,
                                   @Nullable final String defaultValue,
                                   @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getString(key, defaultValue);
    }

    ///////////////////////////////////////////////////////////////////////////
    // about JSONObject
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put JSONObject in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final JSONObject value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put JSONObject in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final JSONObject value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 JSONObject
     * <p>
     * Return the JSONObject in cache.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the JSONObject if cache exists or null otherwise
     */
    public static JSONObject getJSONObject(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getJSONObject(key);
    }

    /**
     * 缓存中读取 JSONObject
     * <p>
     * Return the JSONObject in cache.
     *
     * @param key            The key of cache.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the JSONObject if cache exists or defaultValue otherwise
     */
    public static JSONObject getJSONObject(@NonNull final String key,
                                           @Nullable final JSONObject defaultValue,
                                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getJSONObject(key, defaultValue);
    }

    ///////////////////////////////////////////////////////////////////////////
    // about JSONArray
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put JSONArray in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final JSONArray value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put JSONArray in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final JSONArray value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 JSONArray
     * <p>
     * Return the JSONArray in cache.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the JSONArray if cache exists or null otherwise
     */
    public static JSONArray getJSONArray(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getJSONArray(key);
    }

    /**
     * 缓存中读取 JSONArray
     * <p>
     * Return the JSONArray in cache.
     *
     * @param key            The key of cache.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the JSONArray if cache exists or defaultValue otherwise
     */
    public static JSONArray getJSONArray(@NonNull final String key,
                                         @Nullable final JSONArray defaultValue,
                                         @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getJSONArray(key, defaultValue);
    }

    ///////////////////////////////////////////////////////////////////////////
    // about Bitmap
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put bitmap in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final Bitmap value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put bitmap in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final Bitmap value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 Bitmap
     * <p>
     * Return the bitmap in cache.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the bitmap if cache exists or null otherwise
     */
    public static Bitmap getBitmap(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getBitmap(key);
    }

    /**
     * 缓存中读取 Bitmap
     * <p>
     * Return the bitmap in cache.
     *
     * @param key            The key of cache.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the bitmap if cache exists or defaultValue otherwise
     */
    public static Bitmap getBitmap(@NonNull final String key,
                                   @Nullable final Bitmap defaultValue,
                                   @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getBitmap(key, defaultValue);
    }

    ///////////////////////////////////////////////////////////////////////////
    // about Drawable
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put drawable in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final Drawable value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put drawable in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final Drawable value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 Drawable
     * <p>
     * Return the drawable in cache.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the drawable if cache exists or null otherwise
     */
    public static Drawable getDrawable(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getDrawable(key);
    }

    /**
     * 缓存中读取 Drawable
     * <p>
     * Return the drawable in cache.
     *
     * @param key            The key of cache.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the drawable if cache exists or defaultValue otherwise
     */
    public static Drawable getDrawable(@NonNull final String key,
                                       @Nullable final Drawable defaultValue,
                                       @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getDrawable(key, defaultValue);
    }

    ///////////////////////////////////////////////////////////////////////////
    // about Parcelable
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put parcelable in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final Parcelable value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put parcelable in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final Parcelable value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 Parcelable
     * <p>
     * Return the parcelable in cache.
     *
     * @param key            The key of cache.
     * @param creator        The creator.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @param <T>            The value type.
     * @return the parcelable if cache exists or null otherwise
     */
    public static <T> T getParcelable(@NonNull final String key,
                                      @NonNull final Parcelable.Creator<T> creator,
                                      @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getParcelable(key, creator);
    }

    /**
     * 缓存中读取 Parcelable
     * <p>
     * Return the parcelable in cache.
     *
     * @param key            The key of cache.
     * @param creator        The creator.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @param <T>            The value type.
     * @return the parcelable if cache exists or defaultValue otherwise
     */
    public static <T> T getParcelable(@NonNull final String key,
                                      @NonNull final Parcelable.Creator<T> creator,
                                      @Nullable final T defaultValue,
                                      @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getParcelable(key, creator, defaultValue);
    }

    ///////////////////////////////////////////////////////////////////////////
    // about Serializable
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入数据
     * <p>
     * Put serializable in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final Serializable value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * 缓存中写入数据
     * <p>
     * Put serializable in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final Serializable value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 Serializable
     * <p>
     * Return the serializable in cache.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the bitmap if cache exists or null otherwise
     */
    public static Object getSerializable(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getSerializable(key);
    }

    /**
     * 缓存中读取 Serializable
     * <p>
     * Return the serializable in cache.
     *
     * @param key            The key of cache.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the bitmap if cache exists or defaultValue otherwise
     */
    public static Object getSerializable(@NonNull final String key,
                                         @Nullable final Object defaultValue,
                                         @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getSerializable(key, defaultValue);
    }

    /**
     * 获取缓存大小
     * <p>
     * Return the size of cache, in bytes.
     *
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the size of cache, in bytes
     */
    public static long getCacheSize(@NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getCacheSize();
    }

    /**
     * 获取缓存个数
     * <p>
     * Return the count of cache.
     *
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the count of cache
     */
    public static int getCacheCount(@NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getCacheCount();
    }

    /**
     * 根据键值移除缓存
     * <p>
     * Remove the cache by key.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean remove(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.remove(key);
    }

    /**
     * 清除所有缓存
     * <p>
     * Clear all of the cache.
     *
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean clear(@NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.clear();
    }

    @NonNull
    private static CacheDiskUtils getDefaultCacheDiskUtils() {
        return sDefaultCacheDiskUtils != null ? sDefaultCacheDiskUtils : CacheDiskUtils.getInstance();
    }
}
