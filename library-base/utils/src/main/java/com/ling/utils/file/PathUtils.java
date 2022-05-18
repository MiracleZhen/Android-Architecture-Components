package com.ling.utils.file;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;

import com.ling.utils.Utils;
import com.ling.utils.UtilsBridge;

import java.io.File;

/**
 * author : wangchengzhen
 * github : https://github.com/Blankj/AndroidUtilCode
 * time   : 2021/11/12
 * desc   : utils about path
 */
public final class PathUtils {

    private static final char SEP = File.separatorChar;

    private PathUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 连接路径
     * <p>
     * Join the path.
     *
     * @param parent The parent of path.
     * @param child  The child path.
     * @return the path
     */
    public static String join(String parent, String child) {
        if (TextUtils.isEmpty(child)) return parent;
        if (parent == null) {
            parent = "";
        }
        int len = parent.length();
        String legalSegment = getLegalSegment(child);
        String newPath;
        if (len == 0) {
            newPath = SEP + legalSegment;
        } else if (parent.charAt(len - 1) == SEP) {
            newPath = parent + legalSegment;
        } else {
            newPath = parent + SEP + legalSegment;
        }
        return newPath;
    }

    private static String getLegalSegment(String segment) {
        int st = -1, end = -1;
        char[] charArray = segment.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c != SEP) {
                if (st == -1) {
                    st = i;
                }
                end = i;
            }
        }
        if (st >= 0 && end >= st) {
            return segment.substring(st, end + 1);
        }
        throw new IllegalArgumentException("segment of <" + segment + "> is illegal");
    }

    /**
     * 获取根路径
     * <p>
     * Return the path of /system.
     *
     * @return the path of /system
     */
    public static String getRootPath() {
        return getAbsolutePath(Environment.getRootDirectory());
    }

    /**
     * 获取数据路径
     * <p>
     * Return the path of /data.
     *
     * @return the path of /data
     */
    public static String getDataPath() {
        return getAbsolutePath(Environment.getDataDirectory());
    }

    /**
     * 获取下载缓存路径
     * <p>
     * Return the path of /cache.
     *
     * @return the path of /cache
     */
    public static String getDownloadCachePath() {
        return getAbsolutePath(Environment.getDownloadCacheDirectory());
    }

    /**
     * 获取内存应用数据路径
     * <p>
     * Return the path of /data/data/package.
     *
     * @return the path of /data/data/package
     */
    public static String getInternalAppDataPath() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            return Utils.getApp().getApplicationInfo().dataDir;
        }
        return getAbsolutePath(Utils.getApp().getDataDir());
    }

    /**
     * 获取内存应用代码缓存路径
     * <p>
     * Return the path of /data/data/package/code_cache.
     *
     * @return the path of /data/data/package/code_cache
     */
    public static String getInternalAppCodeCacheDir() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return Utils.getApp().getApplicationInfo().dataDir + "/code_cache";
        }
        return getAbsolutePath(Utils.getApp().getCodeCacheDir());
    }

    /**
     * 获取内存应用缓存路径
     * <p>
     * Return the path of /data/data/package/cache.
     *
     * @return the path of /data/data/package/cache
     */
    public static String getInternalAppCachePath() {
        return getAbsolutePath(Utils.getApp().getCacheDir());
    }

    /**
     * 获取内存应用数据库路径
     * <p>
     * Return the path of /data/data/package/databases.
     *
     * @return the path of /data/data/package/databases
     */
    public static String getInternalAppDbsPath() {
        return Utils.getApp().getApplicationInfo().dataDir + "/databases";
    }

    /**
     * 获取内存应用数据库路径
     * <p>
     * Return the path of /data/data/package/databases/name.
     *
     * @param name The name of database.
     * @return the path of /data/data/package/databases/name
     */
    public static String getInternalAppDbPath(String name) {
        return getAbsolutePath(Utils.getApp().getDatabasePath(name));
    }

    /**
     * 获取内存应用文件路径
     * <p>
     * Return the path of /data/data/package/files.
     *
     * @return the path of /data/data/package/files
     */
    public static String getInternalAppFilesPath() {
        return getAbsolutePath(Utils.getApp().getFilesDir());
    }

    /**
     * 获取内存应用 SP 路径
     * <p>
     * Return the path of /data/data/package/shared_prefs.
     *
     * @return the path of /data/data/package/shared_prefs
     */
    public static String getInternalAppSpPath() {
        return Utils.getApp().getApplicationInfo().dataDir + "/shared_prefs";
    }

    /**
     * 获取内存应用未备份文件路径
     * <p>
     * Return the path of /data/data/package/no_backup.
     *
     * @return the path of /data/data/package/no_backup
     */
    public static String getInternalAppNoBackupFilesPath() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return Utils.getApp().getApplicationInfo().dataDir + "/no_backup";
        }
        return getAbsolutePath(Utils.getApp().getNoBackupFilesDir());
    }

    /**
     * 获取外存路径
     * <p>
     * Return the path of /storage/emulated/0.
     *
     * @return the path of /storage/emulated/0
     */
    public static String getExternalStoragePath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Environment.getExternalStorageDirectory());
    }

    /**
     * 获取外存音乐路径
     * <p>
     * Return the path of /storage/emulated/0/Music.
     *
     * @return the path of /storage/emulated/0/Music
     */
    public static String getExternalMusicPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
    }

    /**
     * 获取外存播客路径
     * <p>
     * Return the path of /storage/emulated/0/Podcasts.
     *
     * @return the path of /storage/emulated/0/Podcasts
     */
    public static String getExternalPodcastsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS));
    }

    /**
     * 获取外存铃声路径
     * <p>
     * Return the path of /storage/emulated/0/Ringtones.
     *
     * @return the path of /storage/emulated/0/Ringtones
     */
    public static String getExternalRingtonesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES));
    }

    /**
     * 获取外存闹铃路径
     * <p>
     * Return the path of /storage/emulated/0/Alarms.
     *
     * @return the path of /storage/emulated/0/Alarms
     */
    public static String getExternalAlarmsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS));
    }

    /**
     * 获取外存通知路径
     * <p>
     * Return the path of /storage/emulated/0/Notifications.
     *
     * @return the path of /storage/emulated/0/Notifications
     */
    public static String getExternalNotificationsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS));
    }

    /**
     * 获取外存图片路径
     * <p>
     * Return the path of /storage/emulated/0/Pictures.
     *
     * @return the path of /storage/emulated/0/Pictures
     */
    public static String getExternalPicturesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    /**
     * 获取外存影片路径
     * <p>
     * Return the path of /storage/emulated/0/Movies.
     *
     * @return the path of /storage/emulated/0/Movies
     */
    public static String getExternalMoviesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES));
    }

    /**
     * 获取外存下载路径
     * <p>
     * Return the path of /storage/emulated/0/Download.
     *
     * @return the path of /storage/emulated/0/Download
     */
    public static String getExternalDownloadsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
    }

    /**
     * 获取外存数码相机图片路径
     * <p>
     * Return the path of /storage/emulated/0/DCIM.
     *
     * @return the path of /storage/emulated/0/DCIM
     */
    public static String getExternalDcimPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
    }

    /**
     * 获取外存文档路径
     * <p>
     * Return the path of /storage/emulated/0/Documents.
     *
     * @return the path of /storage/emulated/0/Documents
     */
    public static String getExternalDocumentsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return getAbsolutePath(Environment.getExternalStorageDirectory()) + "/Documents";
        }
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS));
    }

    /**
     * 获取外存应用数据路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package.
     *
     * @return the path of /storage/emulated/0/Android/data/package
     */
    public static String getExternalAppDataPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        File externalCacheDir = Utils.getApp().getExternalCacheDir();
        if (externalCacheDir == null) return "";
        return getAbsolutePath(externalCacheDir.getParentFile());
    }

    /**
     * 获取外存应用缓存路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package/cache.
     *
     * @return the path of /storage/emulated/0/Android/data/package/cache
     */
    public static String getExternalAppCachePath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Utils.getApp().getExternalCacheDir());
    }

    /**
     * 获取外存应用文件路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package/files.
     *
     * @return the path of /storage/emulated/0/Android/data/package/files
     */
    public static String getExternalAppFilesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(null));
    }

    /**
     * 获取外存应用音乐路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package/files/Music.
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Music
     */
    public static String getExternalAppMusicPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_MUSIC));
    }

    /**
     * 获取外存应用播客路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package/files/Podcasts.
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Podcasts
     */
    public static String getExternalAppPodcastsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_PODCASTS));
    }

    /**
     * 获取外存应用铃声路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package/files/Ringtones.
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Ringtones
     */
    public static String getExternalAppRingtonesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_RINGTONES));
    }

    /**
     * 获取外存应用闹铃路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package/files/Alarms.
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Alarms
     */
    public static String getExternalAppAlarmsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_ALARMS));
    }

    /**
     * 获取外存应用通知路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package/files/Notifications.
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Notifications
     */
    public static String getExternalAppNotificationsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS));
    }

    /**
     * 获取外存应用图片路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package/files/Pictures.
     *
     * @return path of /storage/emulated/0/Android/data/package/files/Pictures
     */
    public static String getExternalAppPicturesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_PICTURES));
    }

    /**
     * 获取外存应用影片路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package/files/Movies.
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Movies
     */
    public static String getExternalAppMoviesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_MOVIES));
    }

    /**
     * 获取外存应用下载路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package/files/Download.
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Download
     */
    public static String getExternalAppDownloadPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
    }

    /**
     * 获取外存应用数码相机图片路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package/files/DCIM.
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/DCIM
     */
    public static String getExternalAppDcimPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_DCIM));
    }

    /**
     * 获取外存应用文档路径
     * <p>
     * Return the path of /storage/emulated/0/Android/data/package/files/Documents.
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Documents
     */
    public static String getExternalAppDocumentsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return getAbsolutePath(Utils.getApp().getExternalFilesDir(null)) + "/Documents";
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS));
    }

    /**
     * 获取外存应用 OBB 路径
     * <p>
     * Return the path of /storage/emulated/0/Android/obb/package.
     *
     * @return the path of /storage/emulated/0/Android/obb/package
     */
    public static String getExternalAppObbPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) return "";
        return getAbsolutePath(Utils.getApp().getObbDir());
    }

    /**
     * 优先获取外部根路径
     */
    public static String getRootPathExternalFirst() {
        String rootPath = getExternalStoragePath();
        if (TextUtils.isEmpty(rootPath)) {
            rootPath = getRootPath();
        }
        return rootPath;
    }

    /**
     * 优先获取外部数据路径
     */
    public static String getAppDataPathExternalFirst() {
        String appDataPath = getExternalAppDataPath();
        if (TextUtils.isEmpty(appDataPath)) {
            appDataPath = getInternalAppDataPath();
        }
        return appDataPath;
    }

    /**
     * 优先获取外部文件路径
     */
    public static String getFilesPathExternalFirst() {
        String filePath = getExternalAppFilesPath();
        if (TextUtils.isEmpty(filePath)) {
            filePath = getInternalAppFilesPath();
        }
        return filePath;
    }

    /**
     * 优先获取外部缓存路径
     */
    public static String getCachePathExternalFirst() {
        String appPath = getExternalAppCachePath();
        if (TextUtils.isEmpty(appPath)) {
            appPath = getInternalAppCachePath();
        }
        return appPath;
    }

    private static String getAbsolutePath(final File file) {
        if (file == null) return "";
        return file.getAbsolutePath();
    }
}
