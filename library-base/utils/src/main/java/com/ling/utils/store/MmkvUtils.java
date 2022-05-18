package com.ling.utils.store;

import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ling.utils.AppUtils;
import com.ling.utils.LogUtils;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVLogLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * author : wangchengzhen
 * github : https://github.com/chengzhen-wang/Android-Architecture-Components
 * time   : 2021/12/7
 * desc   : utils about mmkv - MMKV 相关
 */
public final class MmkvUtils {

    /** 默认单进程密钥 */
    public static String CRYPT_KEY = AppUtils.getAppPackageName();
    /** 默认多进程密钥 */
    public static String CRYPT_KEY_MULTI_PROGRESS = AppUtils.getAppPackageName();

    private static final Map<String, MmkvUtils> MMKV_UTILS_MAP = new HashMap<>();

    private MMKV mmkv;

    /**
     * MMVK 初始化 (默认存储根目录[/data/data/项目包名/files/mmkv])
     *
     * @param context 上下文
     * @return 存储目录
     */
    public static String init(Context context) {
        return init(context, null, AppUtils.isAppDebug(), CRYPT_KEY);
    }

    /**
     * MMVK 初始化
     *
     * @param context 上下文
     * @param dir     存储目录
     * @return 存储目录
     */
    public static String init(Context context, String dir) {
        return init(context, dir, AppUtils.isAppDebug(), CRYPT_KEY);
    }

    /**
     * MMVK 初始化
     *
     * @param context  上下文
     * @param dir      存储目录
     * @param cryptKey 密钥
     * @return 存储目录
     */
    public static String init(Context context, String dir, String cryptKey) {
        return init(context, dir, AppUtils.isAppDebug(), cryptKey);
    }

    /**
     * MMVK 初始化
     *
     * @param context 上下文
     * @param dir     存储目录
     * @param openLog 日志开关
     * @return 存储目录
     */
    public static String init(Context context, String dir, boolean openLog) {
        return init(context, dir, openLog, CRYPT_KEY);
    }

    /**
     * MMVK 初始化
     *
     * @param context  上下文
     * @param dir      存储目录
     * @param openLog  日志开关
     * @param cryptKey 密钥
     * @return 存储目录
     */
    public static String init(Context context, String dir, boolean openLog, String cryptKey) {
        String rootDir;
        if (TextUtils.isEmpty(dir)) {
            rootDir = MMKV.initialize(context);
        } else {
            rootDir = MMKV.initialize(context, dir);
        }
        if (openLog) {
            LogUtils.d(String.format("MMKV root dir: %s", rootDir));
            MMKV.setLogLevel(MMKVLogLevel.LevelDebug);
        } else {
            MMKV.setLogLevel(MMKVLogLevel.LevelNone);
        }
        if (!TextUtils.isEmpty(cryptKey)) {
            CRYPT_KEY = cryptKey;
            CRYPT_KEY_MULTI_PROGRESS = cryptKey;
        }
        return rootDir;
    }

    /**
     * 获取 SP 实例
     *
     * @return the single {@link MmkvUtils} instance
     */
    public static MmkvUtils getInstance() {
        return getInstance("", true);
    }

    /**
     * 获取 SP 实例
     *
     * @param groupId group id
     * @return the single {@link MmkvUtils} instance
     */
    public static MmkvUtils getInstance(String groupId) {
        return getInstance(groupId, false);
    }

    /**
     * 获取 SP 实例
     *
     * @param multiProgress single or multi progress
     * @return the single {@link MmkvUtils} instance
     */
    public static MmkvUtils getInstance(boolean multiProgress) {
        return getInstance(null, multiProgress);
    }

    /**
     * 获取 SP 实例
     *
     * @param groupId       group id
     * @param multiProgress single or multi progress
     * @return the single {@link MmkvUtils} instance
     */
    public static MmkvUtils getInstance(String groupId, boolean multiProgress) {
        if (isSpace(groupId)) groupId = "mmkvUtils";
        MmkvUtils mmkvUtils = MMKV_UTILS_MAP.get(groupId);
        if (mmkvUtils == null)
            synchronized (MmkvUtils.class) {
                mmkvUtils = MMKV_UTILS_MAP.get(groupId);
                if (mmkvUtils == null) {
                    mmkvUtils = new MmkvUtils(groupId, multiProgress);
                    MMKV_UTILS_MAP.put(groupId, mmkvUtils);
                }
            }
        return mmkvUtils;
    }

    private MmkvUtils(String groupId, final boolean multiProgress) {
        if (multiProgress) {
            // 多进程：如果业务需要多进程访问，那么在初始化的时候加上标志位 MMKV.MULTI_PROCESS_MODE
            mmkv = MMKV.mmkvWithID(groupId, MMKV.MULTI_PROCESS_MODE, CRYPT_KEY_MULTI_PROGRESS);
        } else {
            // 单进程
            mmkv = MMKV.mmkvWithID(groupId, MMKV.SINGLE_PROCESS_MODE, CRYPT_KEY);
        }
    }

    /**
     * MMKV 中写入数据
     *
     * @param key   The key of mmkv.
     * @param value The value of mmkv.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public boolean put(String key, Object value) {
        boolean flag = false;
        if (value instanceof byte[]) {
            flag = mmkv.encode(key, (byte[]) value);
        }
        if (value instanceof String) {
            flag = mmkv.encode(key, (String) value);
        }
        if (value instanceof Boolean) {
            flag = mmkv.encode(key, (Boolean) value);
        }
        if (value instanceof Integer) {
            flag = mmkv.encode(key, (Integer) value);
        }
        if (value instanceof Long) {
            flag = mmkv.encode(key, (Long) value);
        }
        if (value instanceof Float) {
            flag = mmkv.encode(key, (Float) value);
        }
        if (value instanceof Double) {
            flag = mmkv.encode(key, (Double) value);
        }
        if (value instanceof Parcelable) {
            flag = mmkv.encode(key, (Parcelable) value);
        }
        return flag;
    }

    /**
     * MMKV 中读取 String
     *
     * @param key The key of mmkv
     * @return the string value if mmkv exists or {@code ""} otherwise
     */
    public String getString(@NonNull final String key) {
        return getString(key, "");
    }

    /**
     * MMKV 中读取 String
     *
     * @param key          The key of mmkv
     * @param defaultValue The default value if the mmkv doesn't exist.
     * @return the string value if sp exists or {@code defaultValue} otherwise
     */
    public String getString(@NonNull final String key, final String defaultValue) {
        return mmkv.decodeString(key, defaultValue);
    }

    /**
     * MMKV 中读取 boolean
     *
     * @param key The key of mmkv.
     * @return the boolean value if mmkv exists or {@code false} otherwise
     */
    public boolean getBoolean(@NonNull final String key) {
        return getBoolean(key, false);
    }

    /**
     * MMKV 中读取 boolean
     *
     * @param key          The key of mmkv.
     * @param defaultValue The default value if the sp doesn't exist.
     * @return the boolean value if mmkv exists or {@code defaultValue} otherwise
     */
    public boolean getBoolean(@NonNull final String key, final boolean defaultValue) {
        return mmkv.getBoolean(key, defaultValue);
    }

    /**
     * MMKV 中读取 int
     *
     * @param key The key of mmkv.
     * @return the int value if mmkv exists or {@code -1} otherwise
     */
    public int getInt(@NonNull final String key) {
        return getInt(key, -1);
    }

    /**
     * MMKV 中读取 int
     *
     * @param key          The key of mmkv.
     * @param defaultValue The default value if the mmkv doesn't exist.
     * @return the int value if sp exists or {@code defaultValue} otherwise
     */
    public int getInt(@NonNull final String key, final int defaultValue) {
        return mmkv.getInt(key, defaultValue);
    }

    /**
     * MMKV 中读取 long
     *
     * @param key The key of mmkv.
     * @return the long value if mmkv exists or {@code -1} otherwise
     */
    public long getLong(@NonNull final String key) {
        return getLong(key, -1L);
    }

    /**
     * MMKV 中读取 long
     *
     * @param key          The key of mmkv.
     * @param defaultValue The default value if the mmkv doesn't exist.
     * @return the long value if sp exists or {@code defaultValue} otherwise
     */
    public long getLong(@NonNull final String key, final long defaultValue) {
        return mmkv.getLong(key, defaultValue);
    }

    /**
     * MMKV 中读取 float
     *
     * @param key The key of mmkv.
     * @return the float value if mmkv exists or {@code -1f} otherwise
     */
    public float getFloat(@NonNull final String key) {
        return getFloat(key, -1f);
    }

    /**
     * MMKV 中读取 float
     *
     * @param key          The key of mmkv.
     * @param defaultValue The default value if the mmkv doesn't exist.
     * @return the float value if mmkv exists or {@code defaultValue} otherwise
     */
    public float getFloat(@NonNull final String key, final float defaultValue) {
        return mmkv.decodeFloat(key, defaultValue);
    }

    /**
     * MMKV 中读取 double
     *
     * @param key The key of mmkv.
     * @return the double value if mmkv exists or {@code -1d} otherwise
     */
    public double getDouble(@NonNull final String key) {
        return getDouble(key, -1d);
    }

    /**
     * MMKV 中读取 double
     *
     * @param key          The key of mmkv.
     * @param defaultValue The default value if the mmkv doesn't exist.
     * @return the double value if mmkv exists or {@code defaultValue} otherwise
     */
    public double getDouble(@NonNull final String key, final double defaultValue) {
        return mmkv.decodeDouble(key, defaultValue);
    }

    /**
     * MMKV 中读取 byte[]
     *
     * @param key The key of mmkv.
     * @return the byte[] value if mmkv exists or {@code null} otherwise
     */
    public byte[] getBytes(@NonNull final String key) {
        return getBytes(key, null);
    }

    /**
     * MMKV 中读取 byte[]
     *
     * @param key          The key of mmkv.
     * @param defaultValue The default value if the mmkv doesn't exist.
     * @return the byte[] value if mmkv exists or {@code defaultValue} otherwise
     */
    public byte[] getBytes(@NonNull final String key, final byte[] defaultValue) {
        return mmkv.decodeBytes(key, defaultValue);
    }

    /**
     * MMKV 中读取 object
     *
     * @param key   The key of mmkv.
     * @param clazz class
     * @param <T>   泛型
     * @return the object value if mmkv exists or {@code null} otherwise
     */
    public <T extends Parcelable> T getParcelable(@NonNull final String key, Class<T> clazz) {
        return getParcelable(key, clazz, null);
    }

    /**
     * MMKV 中读取 object
     *
     * @param key          The key of mmkv.
     * @param clazz        class
     * @param defaultValue The default value if the mmkv doesn't exist.
     * @param <T>          泛型
     * @return the object value if mmkv exists or {@code defaultValue} otherwise
     */
    public <T extends Parcelable> T getParcelable(@NonNull final String key, Class<T> clazz, @Nullable T defaultValue) {
        return mmkv.decodeParcelable(key, clazz, defaultValue);
    }

    /**
     * MMKV 中是否存在该 key
     *
     * @param key The key of mmkv.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public boolean contains(@NonNull final String key) {
        return mmkv.contains(key);
    }

    /**
     * MMKV 中移除该 key
     *
     * @param key The key of sp.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public boolean remove(@NonNull final String key) {
        mmkv.remove(key);
        return contains(key);
    }

    /**
     * MMVK 中清除所有数据
     */
    public void clear() {
        mmkv.clear();
    }

    private static boolean isSpace(final String s) {
        if (s == null) return true;
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
