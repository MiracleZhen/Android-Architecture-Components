package com.ling.utils.file;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;

import androidx.annotation.RequiresApi;

import com.ling.utils.Utils;
import com.ling.utils.UtilsBridge;

import java.io.File;

/**
 * author : wangchengzhen
 * github : https://github.com/Blankj/AndroidUtilCode
 * time   : 2021/11/13
 * desc   : utils about clean - 清除相关
 */
public final class CleanUtils {

    private CleanUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 清除内部缓存
     * <p>
     * Clean the internal cache.
     * <p>directory: /data/data/package/cache</p>
     *
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean cleanInternalCache() {
        return UtilsBridge.deleteAllInDir(Utils.getApp().getCacheDir());
    }

    /**
     * 清除内部文件
     * <p>
     * Clean the internal files.
     * <p>directory: /data/data/package/files</p>
     *
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean cleanInternalFiles() {
        return UtilsBridge.deleteAllInDir(Utils.getApp().getFilesDir());
    }

    /**
     * 清除内部数据库
     * <p>
     * Clean the internal databases.
     * <p>directory: /data/data/package/databases</p>
     *
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean cleanInternalDbs() {
        return UtilsBridge.deleteAllInDir(new File(Utils.getApp().getFilesDir().getParent(), "databases"));
    }

    /**
     * 根据名称清除数据库
     * <p>
     * Clean the internal database by name.
     * <p>directory: /data/data/package/databases/dbName</p>
     *
     * @param dbName The name of database.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean cleanInternalDbByName(final String dbName) {
        return Utils.getApp().deleteDatabase(dbName);
    }

    /**
     * 清除内部 SP
     * <p>
     * Clean the internal shared preferences.
     * <p>directory: /data/data/package/shared_prefs</p>
     *
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean cleanInternalSp() {
        return UtilsBridge.deleteAllInDir(new File(Utils.getApp().getFilesDir().getParent(), "shared_prefs"));
    }

    /**
     * 清除外部缓存
     * <p>
     * Clean the external cache.
     * <p>directory: /storage/emulated/0/android/data/package/cache</p>
     *
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean cleanExternalCache() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                && UtilsBridge.deleteAllInDir(Utils.getApp().getExternalCacheDir());
    }

    /**
     * 清除自定义目录下的文件
     * <p>
     * Clean the custom directory.
     *
     * @param dirPath The path of directory.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean cleanCustomDir(final String dirPath) {
        return UtilsBridge.deleteAllInDir(UtilsBridge.getFileByPath(dirPath));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void cleanAppUserData() {
        ActivityManager am = (ActivityManager) Utils.getApp().getSystemService(Context.ACTIVITY_SERVICE);
        // noinspection ConstantConditions
        am.clearApplicationUserData();
    }
}
