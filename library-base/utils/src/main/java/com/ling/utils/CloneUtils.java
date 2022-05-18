package com.ling.utils;

import java.lang.reflect.Type;

/**
 * author : wangchengzhen
 * github : https://github.com/Blankj/AndroidUtilCode
 * time   : 2021/11/12
 * desc   : utils about clone - 克隆相关
 */
public final class CloneUtils {

    private CloneUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 深度克隆
     * <p>
     * Deep clone.
     *
     * @param data The data.
     * @param type The type.
     * @param <T>  The value type.
     * @return The object of cloned.
     */
    public static <T> T deepClone(final T data, final Type type) {
        try {
            return UtilsBridge.fromJson(UtilsBridge.toJson(data), type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
