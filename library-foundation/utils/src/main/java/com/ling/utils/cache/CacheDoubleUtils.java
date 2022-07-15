package com.ling.utils.cache;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.ling.utils.constant.CacheConstants;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * author : wangchengzhen
 * github : https://github.com/Blankj/AndroidUtilCode
 * time   : 2021/11/13
 * desc   : utils about double cache - 二级缓存相关
 */
public final class CacheDoubleUtils implements CacheConstants {

    private static final Map<String, CacheDoubleUtils> CACHE_MAP = new HashMap<>();

    /** 内存缓存 */
    private final CacheMemoryUtils mCacheMemoryUtils;
    /** 磁盘缓存 */
    private final CacheDiskUtils mCacheDiskUtils;

    /**
     * 获取缓存实例
     * <p>
     * Return the single {@link CacheDoubleUtils} instance.
     *
     * @return the single {@link CacheDoubleUtils} instance
     */
    public static CacheDoubleUtils getInstance() {
        return getInstance(CacheMemoryUtils.getInstance(), CacheDiskUtils.getInstance());
    }

    /**
     * 获取缓存实例
     * <p>
     * Return the single {@link CacheDoubleUtils} instance.
     *
     * @param cacheMemoryUtils The instance of {@link CacheMemoryUtils}.
     * @param cacheDiskUtils   The instance of {@link CacheDiskUtils}.
     * @return the single {@link CacheDoubleUtils} instance
     */
    public static CacheDoubleUtils getInstance(@NonNull final CacheMemoryUtils cacheMemoryUtils,
                                               @NonNull final CacheDiskUtils cacheDiskUtils) {
        final String cacheKey = cacheDiskUtils.toString() + "_" + cacheMemoryUtils.toString();
        CacheDoubleUtils cache = CACHE_MAP.get(cacheKey);
        if (cache == null) {
            synchronized (CacheDoubleUtils.class) {
                cache = CACHE_MAP.get(cacheKey);
                if (cache == null) {
                    cache = new CacheDoubleUtils(cacheMemoryUtils, cacheDiskUtils);
                    CACHE_MAP.put(cacheKey, cache);
                }
            }
        }
        return cache;
    }

    private CacheDoubleUtils(CacheMemoryUtils cacheMemoryUtils, CacheDiskUtils cacheUtils) {
        mCacheMemoryUtils = cacheMemoryUtils;
        mCacheDiskUtils = cacheUtils;
    }

    ///////////////////////////////////////////////////////////////////////////
    // about bytes
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入 字节 数据
     * <p>
     * Put bytes in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public void put(@NonNull final String key, final byte[] value) {
        put(key, value, -1);
    }

    /**
     * 缓存中写入 字节 数据
     * <p>
     * Put bytes in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public void put(@NonNull final String key, byte[] value, final int saveTime) {
        mCacheMemoryUtils.put(key, value, saveTime);
        mCacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取字节数组
     * <p>
     * Return the bytes in cache.
     *
     * @param key The key of cache.
     * @return the bytes if cache exists or null otherwise
     */
    public byte[] getBytes(@NonNull final String key) {
        return getBytes(key, null);
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
    public byte[] getBytes(@NonNull final String key, final byte[] defaultValue) {
        byte[] obj = mCacheMemoryUtils.get(key);
        if (obj != null) return obj;
        byte[] bytes = mCacheDiskUtils.getBytes(key);
        if (bytes != null) {
            mCacheMemoryUtils.put(key, bytes);
            return bytes;
        }
        return defaultValue;
    }

    ///////////////////////////////////////////////////////////////////////////
    // about String
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入 String 数据
     * <p>
     * Put string value in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public void put(@NonNull final String key, final String value) {
        put(key, value, -1);
    }

    /**
     * 缓存中写入 String 数据
     * <p>
     * Put string value in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public void put(@NonNull final String key, final String value, final int saveTime) {
        mCacheMemoryUtils.put(key, value, saveTime);
        mCacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 String
     * <p>
     * Return the string value in cache.
     *
     * @param key The key of cache.
     * @return the string value if cache exists or null otherwise
     */
    public String getString(@NonNull final String key) {
        return getString(key, null);
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
    public String getString(@NonNull final String key, final String defaultValue) {
        String obj = mCacheMemoryUtils.get(key);
        if (obj != null) return obj;
        String string = mCacheDiskUtils.getString(key);
        if (string != null) {
            mCacheMemoryUtils.put(key, string);
            return string;
        }
        return defaultValue;
    }

    ///////////////////////////////////////////////////////////////////////////
    // about JSONObject
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入 JSONObject 数据
     * <p>
     * Put JSONObject in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public void put(@NonNull final String key, final JSONObject value) {
        put(key, value, -1);
    }

    /**
     * 缓存中写入 JSONObject 数据
     * <p>
     * Put JSONObject in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public void put(@NonNull final String key,
                    final JSONObject value,
                    final int saveTime) {
        mCacheMemoryUtils.put(key, value, saveTime);
        mCacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 JSONObject
     * <p>
     * Return the JSONObject in cache.
     *
     * @param key The key of cache.
     * @return the JSONObject if cache exists or null otherwise
     */
    public JSONObject getJSONObject(@NonNull final String key) {
        return getJSONObject(key, null);
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
    public JSONObject getJSONObject(@NonNull final String key, final JSONObject defaultValue) {
        JSONObject obj = mCacheMemoryUtils.get(key);
        if (obj != null) return obj;
        JSONObject jsonObject = mCacheDiskUtils.getJSONObject(key);
        if (jsonObject != null) {
            mCacheMemoryUtils.put(key, jsonObject);
            return jsonObject;
        }
        return defaultValue;
    }

    ///////////////////////////////////////////////////////////////////////////
    // about JSONArray
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入 JSONArray 数据
     * <p>
     * Put JSONArray in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public void put(@NonNull final String key, final JSONArray value) {
        put(key, value, -1);
    }

    /**
     * 缓存中写入 JSONArray 数据
     * <p>
     * Put JSONArray in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public void put(@NonNull final String key, final JSONArray value, final int saveTime) {
        mCacheMemoryUtils.put(key, value, saveTime);
        mCacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 JSONArray
     * <p>
     * Return the JSONArray in cache.
     *
     * @param key The key of cache.
     * @return the JSONArray if cache exists or null otherwise
     */
    public JSONArray getJSONArray(@NonNull final String key) {
        return getJSONArray(key, null);
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
    public JSONArray getJSONArray(@NonNull final String key, final JSONArray defaultValue) {
        JSONArray obj = mCacheMemoryUtils.get(key);
        if (obj != null) return obj;
        JSONArray jsonArray = mCacheDiskUtils.getJSONArray(key);
        if (jsonArray != null) {
            mCacheMemoryUtils.put(key, jsonArray);
            return jsonArray;
        }
        return defaultValue;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Bitmap cache
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入 Bitmap 数据
     * <p>
     * Put bitmap in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public void put(@NonNull final String key, final Bitmap value) {
        put(key, value, -1);
    }

    /**
     * 缓存中写入 Bitmap 数据
     * <p>
     * Put bitmap in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public void put(@NonNull final String key, final Bitmap value, final int saveTime) {
        mCacheMemoryUtils.put(key, value, saveTime);
        mCacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 Bitmap
     * <p>
     * Return the bitmap in cache.
     *
     * @param key The key of cache.
     * @return the bitmap if cache exists or null otherwise
     */
    public Bitmap getBitmap(@NonNull final String key) {
        return getBitmap(key, null);
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
    public Bitmap getBitmap(@NonNull final String key, final Bitmap defaultValue) {
        Bitmap obj = mCacheMemoryUtils.get(key);
        if (obj != null) return obj;
        Bitmap bitmap = mCacheDiskUtils.getBitmap(key);
        if (bitmap != null) {
            mCacheMemoryUtils.put(key, bitmap);
            return bitmap;
        }
        return defaultValue;
    }

    ///////////////////////////////////////////////////////////////////////////
    // about Drawable
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入 Drawable 数据
     * <p>
     * Put drawable in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public void put(@NonNull final String key, final Drawable value) {
        put(key, value, -1);
    }

    /**
     * 缓存中写入 Drawable 数据
     * <p>
     * Put drawable in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public void put(@NonNull final String key, final Drawable value, final int saveTime) {
        mCacheMemoryUtils.put(key, value, saveTime);
        mCacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 Drawable
     * <p>
     * Return the drawable in cache.
     *
     * @param key The key of cache.
     * @return the drawable if cache exists or null otherwise
     */
    public Drawable getDrawable(@NonNull final String key) {
        return getDrawable(key, null);
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
    public Drawable getDrawable(@NonNull final String key, final Drawable defaultValue) {
        Drawable obj = mCacheMemoryUtils.get(key);
        if (obj != null) return obj;
        Drawable drawable = mCacheDiskUtils.getDrawable(key);
        if (drawable != null) {
            mCacheMemoryUtils.put(key, drawable);
            return drawable;
        }
        return defaultValue;
    }

    ///////////////////////////////////////////////////////////////////////////
    // about Parcelable
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入 Parcelable 数据
     * <p>
     * Put parcelable in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public void put(@NonNull final String key, final Parcelable value) {
        put(key, value, -1);
    }

    /**
     * 缓存中写入 Parcelable 数据
     * <p>
     * Put parcelable in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public void put(@NonNull final String key, final Parcelable value, final int saveTime) {
        mCacheMemoryUtils.put(key, value, saveTime);
        mCacheDiskUtils.put(key, value, saveTime);
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
    public <T> T getParcelable(@NonNull final String key,
                               @NonNull final Parcelable.Creator<T> creator) {
        return getParcelable(key, creator, null);
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
    public <T> T getParcelable(@NonNull final String key,
                               @NonNull final Parcelable.Creator<T> creator,
                               final T defaultValue) {
        T value = mCacheMemoryUtils.get(key);
        if (value != null) return value;
        T val = mCacheDiskUtils.getParcelable(key, creator);
        if (val != null) {
            mCacheMemoryUtils.put(key, val);
            return val;
        }
        return defaultValue;
    }

    ///////////////////////////////////////////////////////////////////////////
    // about Serializable
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 缓存中写入 Serializable 数据
     * <p>
     * Put serializable in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public void put(@NonNull final String key, final Serializable value) {
        put(key, value, -1);
    }

    /**
     * 缓存中写入 Serializable 数据
     * <p>
     * Put serializable in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public void put(@NonNull final String key, final Serializable value, final int saveTime) {
        mCacheMemoryUtils.put(key, value, saveTime);
        mCacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * 缓存中读取 Serializable
     * <p>
     * Return the serializable in cache.
     *
     * @param key The key of cache.
     * @return the bitmap if cache exists or null otherwise
     */
    public Object getSerializable(@NonNull final String key) {
        return getSerializable(key, null);
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
    public Object getSerializable(@NonNull final String key, final Object defaultValue) {
        Object obj = mCacheMemoryUtils.get(key);
        if (obj != null) return obj;
        Object serializable = mCacheDiskUtils.getSerializable(key);
        if (serializable != null) {
            mCacheMemoryUtils.put(key, serializable);
            return serializable;
        }
        return defaultValue;
    }

    /**
     * 获取磁盘缓存大小
     * <p>
     * Return the size of cache in disk.
     *
     * @return the size of cache in disk
     */
    public long getCacheDiskSize() {
        return mCacheDiskUtils.getCacheSize();
    }

    /**
     * 获取磁盘缓存个数
     * <p>
     * Return the count of cache in disk.
     *
     * @return the count of cache in disk
     */
    public int getCacheDiskCount() {
        return mCacheDiskUtils.getCacheCount();
    }

    /**
     * 获取内存缓存个数
     * <p>
     * Return the count of cache in memory.
     *
     * @return the count of cache in memory.
     */
    public int getCacheMemoryCount() {
        return mCacheMemoryUtils.getCacheCount();
    }

    /**
     * 根据键值移除缓存
     * <p>
     * Remove the cache by key.
     *
     * @param key The key of cache.
     */
    public void remove(@NonNull String key) {
        mCacheMemoryUtils.remove(key);
        mCacheDiskUtils.remove(key);
    }

    /**
     * 清除所有缓存
     * <p>
     * Clear all of the cache.
     */
    public void clear() {
        mCacheMemoryUtils.clear();
        mCacheDiskUtils.clear();
    }
}
