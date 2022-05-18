package com.ling.utils;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;

import com.google.gson.Gson;
import com.ling.utils.encrypt.EncodeUtils;
import com.ling.utils.encrypt.EncryptUtils;
import com.ling.utils.file.FileIOUtils;
import com.ling.utils.file.FileUtils;
import com.ling.utils.file.SDCardUtils;
import com.ling.utils.parse.GsonUtils;
import com.ling.utils.parse.JsonUtils;
import com.ling.utils.resource.AdaptScreenUtils;
import com.ling.utils.resource.BarUtils;
import com.ling.utils.resource.SizeUtils;
import com.ling.utils.store.SPUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static android.Manifest.permission.CALL_PHONE;

/**
 * author : wangchengzhen
 * github : https://github.com/Blankj/AndroidUtilCode
 * time   : 2021/11/12
 * desc   : 桥
 */
public class UtilsBridge {

    /**
     * 注册 lifecycle
     */
    static void register(Application app) {
        UtilsActivityLifecycleImpl.INSTANCE.register(app);
    }

    /**
     * 注销 lifecycle
     */
    static void unregister(Application app) {
        UtilsActivityLifecycleImpl.INSTANCE.unregister(app);
    }

    /**
     * 预加载屏幕适配
     */
    static void preLoad() {
        preLoad(AdaptScreenUtils.getPreLoadRunnable());
    }

    private static void preLoad(final Runnable... runs) {
        for (final Runnable r : runs) {
            ThreadUtils.getCachedPool().execute(r);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // UtilsActivityLifecycleImpl
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 获取栈顶 Activity
     */
    static Activity getTopActivity() {
        return UtilsActivityLifecycleImpl.INSTANCE.getTopActivity();
    }

    /**
     * 注册 App 前后台切换监听器
     */
    static void addOnAppStatusChangedListener(final Utils.OnAppStatusChangedListener listener) {
        UtilsActivityLifecycleImpl.INSTANCE.addOnAppStatusChangedListener(listener);
    }

    /**
     * 注销 App 前后台切换监听器
     */
    static void removeOnAppStatusChangedListener(final Utils.OnAppStatusChangedListener listener) {
        UtilsActivityLifecycleImpl.INSTANCE.removeOnAppStatusChangedListener(listener);
    }

    /**
     * 增加 Activity 生命周期监听
     */
    static void addActivityLifecycleCallbacks(final Utils.ActivityLifecycleCallbacks callbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.addActivityLifecycleCallbacks(callbacks);
    }

    /**
     * 移除 Activity 生命周期监听
     */
    static void removeActivityLifecycleCallbacks(final Utils.ActivityLifecycleCallbacks callbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(callbacks);
    }

    /**
     * 增加 Activity 生命周期监听
     */
    static void addActivityLifecycleCallbacks(final Activity activity,
                                              final Utils.ActivityLifecycleCallbacks callbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.addActivityLifecycleCallbacks(activity, callbacks);
    }

    /**
     * 移除 Activity 生命周期监听
     */
    static void removeActivityLifecycleCallbacks(final Activity activity) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activity);
    }

    /**
     * 移除 Activity 生命周期监听
     */
    static void removeActivityLifecycleCallbacks(final Activity activity,
                                                 final Utils.ActivityLifecycleCallbacks callbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activity, callbacks);
    }

    /**
     * 获取 Activity 栈链表
     */
    static List<Activity> getActivityList() {
        return UtilsActivityLifecycleImpl.INSTANCE.getActivityList();
    }

    /**
     * 通过反射获取 Application 对象
     */
    static Application getApplicationByReflect() {
        return Utils.getApplicationByReflect();
    }

    /**
     * 判断 App 是否处于前台
     */
    static boolean isAppForeground() {
        return UtilsActivityLifecycleImpl.INSTANCE.isAppForeground();
    }

    ///////////////////////////////////////////////////////////////////////////
    // ActivityUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 判断 Activity 是否存活
     */
    public static boolean isActivityAlive(final Activity activity) {
        return ActivityUtils.isActivityAlive(activity);
    }

    /**
     * 获取启动项 Activity
     */
    public static String getLauncherActivity(final String pkg) {
        return ActivityUtils.getLauncherActivity(pkg);
    }

    /**
     * 根据上下文获取 Activity
     */
    public static Activity getActivityByContext(Context context) {
        return ActivityUtils.getActivityByContext(context);
    }

    /**
     * 回到桌面
     */
    public static void startHomeActivity() {
        ActivityUtils.startHomeActivity();
    }

    /**
     * 结束所有 Activity
     */
    public static void finishAllActivities() {
        ActivityUtils.finishAllActivities();
    }

    ///////////////////////////////////////////////////////////////////////////
    // AppUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 判断 App 是否运行
     */
    static boolean isAppRunning(@NonNull final String pkgName) {
        return AppUtils.isAppRunning(pkgName);
    }

    /**
     * 判断 App 是否安装
     */
    static boolean isAppInstalled(final String pkgName) {
        return AppUtils.isAppInstalled(pkgName);
    }

    /**
     * 判断 App 是否是 Debug 版本
     */
    static boolean isAppDebug() {
        return AppUtils.isAppDebug();
    }

    /**
     * 重启 App
     */
    static void relaunchApp() {
        AppUtils.relaunchApp();
    }

    ///////////////////////////////////////////////////////////////////////////
    // BarUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 获取状态栏高度（px）
     */
    static int getStatusBarHeight() {
        return BarUtils.getStatusBarHeight();
    }

    /**
     * 获取导航栏高度
     */
    static int getNavBarHeight() {
        return BarUtils.getNavBarHeight();
    }

    ///////////////////////////////////////////////////////////////////////////
    // ConvertUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * bytes 转 hexString
     */
    public static String bytes2HexString(final byte[] bytes) {
        return ConvertUtils.bytes2HexString(bytes);
    }

    /**
     * hexString 转 bytes
     */
    public static byte[] hexString2Bytes(String hexString) {
        return ConvertUtils.hexString2Bytes(hexString);
    }

    /**
     * string 转 bytes
     */
    public static byte[] string2Bytes(final String string) {
        return ConvertUtils.string2Bytes(string);
    }

    /**
     * bytes 转 string
     */
    public static String bytes2String(final byte[] bytes) {
        return ConvertUtils.bytes2String(bytes);
    }

    /**
     * JSONObject 转 bytes
     */
    public static byte[] jsonObject2Bytes(final JSONObject jsonObject) {
        return ConvertUtils.jsonObject2Bytes(jsonObject);
    }

    /**
     * bytes 转 JSONObject
     */
    public static JSONObject bytes2JSONObject(final byte[] bytes) {
        return ConvertUtils.bytes2JSONObject(bytes);
    }

    /**
     * JSONArray 转 bytes
     */
    public static byte[] jsonArray2Bytes(final JSONArray jsonArray) {
        return ConvertUtils.jsonArray2Bytes(jsonArray);
    }

    /**
     * bytes 转 JSONArray
     */
    public static JSONArray bytes2JSONArray(final byte[] bytes) {
        return ConvertUtils.bytes2JSONArray(bytes);
    }

    /**
     * Parcelable 转 bytes
     */
    public static byte[] parcelable2Bytes(final Parcelable parcelable) {
        return ConvertUtils.parcelable2Bytes(parcelable);
    }

    /**
     * bytes 转 Parcelable
     */
    public static <T> T bytes2Parcelable(final byte[] bytes,
                                  final Parcelable.Creator<T> creator) {
        return ConvertUtils.bytes2Parcelable(bytes, creator);
    }

    /**
     * Object 转 bytes
     */
    public static byte[] serializable2Bytes(final Serializable serializable) {
        return ConvertUtils.serializable2Bytes(serializable);
    }

    /**
     * bytes 转 Object
     */
    public static Object bytes2Object(final byte[] bytes) {
        return ConvertUtils.bytes2Object(bytes);
    }

    /**
     * 字节数转合适内存大小
     */
    public static String byte2FitMemorySize(final long byteSize) {
        return ConvertUtils.byte2FitMemorySize(byteSize);
    }

    /**
     * inputStream 转 bytes
     */
    public static byte[] inputStream2Bytes(final InputStream is) {
        return ConvertUtils.inputStream2Bytes(is);
    }

    /**
     * inputStream 转 outputStream
     */
    public static ByteArrayOutputStream input2OutputStream(final InputStream is) {
        return ConvertUtils.input2OutputStream(is);
    }

    /**
     * inputStream 转 文本行
     */
    public static List<String> inputStream2Lines(final InputStream is, final String charsetName) {
        return ConvertUtils.inputStream2Lines(is, charsetName);
    }

    ///////////////////////////////////////////////////////////////////////////
    // DebouncingUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 是否有效
     */
    static boolean isValid(@NonNull final View view, final long duration) {
        return DebouncingUtils.isValid(view, duration);
    }

    ///////////////////////////////////////////////////////////////////////////
    // EncodeUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Base64 编码
     */
    public static byte[] base64Encode(final byte[] input) {
        return EncodeUtils.base64Encode(input);
    }

    /**
     * Base64 解码
     */
    public static byte[] base64Decode(final byte[] input) {
        return EncodeUtils.base64Decode(input);
    }

    ///////////////////////////////////////////////////////////////////////////
    // EncryptUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 哈希加密(hash encryption)
     */
    static byte[] hashTemplate(final byte[] data, final String algorithm) {
        return EncryptUtils.hashTemplate(data, algorithm);
    }

    ///////////////////////////////////////////////////////////////////////////
    // FileIOUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 将字节数组写入文件
     */
    public static boolean writeFileFromBytes(final File file,
                                      final byte[] bytes) {
        return FileIOUtils.writeFileFromBytesByChannel(file, bytes, true);
    }

    /**
     * 读取文件到字节数组中
     */
    public static byte[] readFile2Bytes(final File file) {
        return FileIOUtils.readFile2BytesByChannel(file);
    }

    /**
     * 将字符串写入文件
     */
    public static boolean writeFileFromString(final String filePath, final String content, final boolean append) {
        return FileIOUtils.writeFileFromString(filePath, content, append);
    }

    /**
     * 将输入流写入文件
     */
    public static boolean writeFileFromIS(final String filePath, final InputStream is) {
        return FileIOUtils.writeFileFromIS(filePath, is);
    }

    ///////////////////////////////////////////////////////////////////////////
    // FileUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 判断文件是否存在
     */
    public static boolean isFileExists(final File file) {
        return FileUtils.isFileExists(file);
    }

    /**
     * 根据文件路径获取文件
     */
    public static File getFileByPath(final String filePath) {
        return FileUtils.getFileByPath(filePath);
    }

    /**
     * 删除目录下所有内容
     */
    public static boolean deleteAllInDir(final File dir) {
        return FileUtils.deleteAllInDir(dir);
    }

    /**
     * 判断文件是否存在，不存在则判断是否创建成功
     */
    public static boolean createOrExistsFile(final File file) {
        return FileUtils.createOrExistsFile(file);
    }

    /**
     * 判断目录是否存在，不存在则判断是否创建成功
     */
    public static boolean createOrExistsDir(final File file) {
        return FileUtils.createOrExistsDir(file);
    }

    /**
     * 判断文件是否存在，存在则在创建之前删除
     */
    public static boolean createFileByDeleteOldFile(final File file) {
        return FileUtils.createFileByDeleteOldFile(file);
    }

    /**
     * 获取文件系统总大小
     */
    public static long getFsTotalSize(String path) {
        return FileUtils.getFsTotalSize(path);
    }

    /**
     * 获取文件系统可用大小
     */
    public static long getFsAvailableSize(String path) {
        return FileUtils.getFsAvailableSize(path);
    }

    /**
     * 通知系统扫描文件
     */
    public static void notifySystemToScan(File file) {
        FileUtils.notifySystemToScan(file);
    }

    ///////////////////////////////////////////////////////////////////////////
    // GsonUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 对象转 Json 串
     */
    static String toJson(final Object object) {
        return GsonUtils.toJson(object);
    }

    /**
     * Json 串转对象
     */
    static <T> T fromJson(final String json, final Type type) {
        return GsonUtils.fromJson(json, type);
    }

    static Gson getGson4LogUtils() {
        return GsonUtils.getGson4LogUtils();
    }

    ///////////////////////////////////////////////////////////////////////////
    // ImageUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * bitmap 转 bytes
     */
    public static byte[] bitmap2Bytes(final Bitmap bitmap) {
        return ImageUtils.bitmap2Bytes(bitmap);
    }

    /**
     * bitmap 转 bytes
     */
    public static byte[] bitmap2Bytes(final Bitmap bitmap, final Bitmap.CompressFormat format, int quality) {
        return ImageUtils.bitmap2Bytes(bitmap, format, quality);
    }

    /**
     * bytes 转 bitmap
     */
    public static Bitmap bytes2Bitmap(final byte[] bytes) {
        return ImageUtils.bytes2Bitmap(bytes);
    }

    /**
     * drawable 转 bytes
     */
    public static byte[] drawable2Bytes(final Drawable drawable) {
        return ImageUtils.drawable2Bytes(drawable);
    }

    /**
     * drawable 转 bytes
     */
    public static byte[] drawable2Bytes(final Drawable drawable, final Bitmap.CompressFormat format, int quality) {
        return ImageUtils.drawable2Bytes(drawable, format, quality);
    }

    /**
     * bytes 转 drawable
     */
    public static Drawable bytes2Drawable(final byte[] bytes) {
        return ImageUtils.bytes2Drawable(bytes);
    }

    /**
     * view 转 bitmap
     */
    public static Bitmap view2Bitmap(final View view) {
        return ImageUtils.view2Bitmap(view);
    }

    /**
     * drawable 转 bitmap
     */
    public static Bitmap drawable2Bitmap(final Drawable drawable) {
        return ImageUtils.drawable2Bitmap(drawable);
    }

    /**
     * bitmap 转 drawable
     */
    public static Drawable bitmap2Drawable(final Bitmap bitmap) {
        return ImageUtils.bitmap2Drawable(bitmap);
    }

    ///////////////////////////////////////////////////////////////////////////
    // IntentUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 判断意图是否可用
     */
    static boolean isIntentAvailable(final Intent intent) {
        return IntentUtils.isIntentAvailable(intent);
    }

    /**
     * 获取打开 App 的意图
     */
    static Intent getLaunchAppIntent(final String pkgName) {
        return IntentUtils.getLaunchAppIntent(pkgName);
    }

    /**
     * 获取安装 App（支持 6.0）的意图
     */
    static Intent getInstallAppIntent(final File file) {
        return IntentUtils.getInstallAppIntent(file);
    }

    /**
     * 获取安装 App（支持 6.0）的意图
     */
    static Intent getInstallAppIntent(final Uri uri) {
        return IntentUtils.getInstallAppIntent(uri);
    }

    /**
     * 获取卸载 App 的意图
     */
    static Intent getUninstallAppIntent(final String pkgName) {
        return IntentUtils.getUninstallAppIntent(pkgName);
    }

    /**
     * 获取拨号的意图
     */
    static Intent getDialIntent(final String phoneNumber) {
        return IntentUtils.getDialIntent(phoneNumber);
    }

    /**
     * 获取打电话的意图
     */
    @RequiresPermission(CALL_PHONE)
    static Intent getCallIntent(final String phoneNumber) {
        return IntentUtils.getCallIntent(phoneNumber);
    }

    /**
     * 获取发短信的意图
     */
    static Intent getSendSmsIntent(final String phoneNumber, final String content) {
        return IntentUtils.getSendSmsIntent(phoneNumber, content);
    }

    /**
     * 获取 App 具体设置的意图
     */
    static Intent getLaunchAppDetailsSettingsIntent(final String pkgName, final boolean isNewTask) {
        return IntentUtils.getLaunchAppDetailsSettingsIntent(pkgName, isNewTask);
    }

    ///////////////////////////////////////////////////////////////////////////
    // JsonUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 格式化json字符串
     */
    static String formatJson(String json) {
        return JsonUtils.formatJson(json);
    }

    ///////////////////////////////////////////////////////////////////////////
    // KeyboardUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 修复软键盘内存泄漏
     */
    static void fixSoftInputLeaks(final Activity activity) {
        KeyboardUtils.fixSoftInputLeaks(activity);
    }

    ///////////////////////////////////////////////////////////////////////////
    // NotificationUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 创建通知
     */
    static Notification getNotification(NotificationUtils.ChannelConfig channelConfig,
                                        Utils.Consumer<NotificationCompat.Builder> consumer) {
        return NotificationUtils.getNotification(channelConfig, consumer);
    }

    ///////////////////////////////////////////////////////////////////////////
    // PermissionUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 判断权限是否被授予
     */
    static boolean isGranted(final String... permissions) {
        return PermissionUtils.isGranted(permissions);
    }

    /**
     * 判断悬浮窗权限是否被授予
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    static boolean isGrantedDrawOverlays() {
        return PermissionUtils.isGrantedDrawOverlays();
    }

    ///////////////////////////////////////////////////////////////////////////
    // ProcessUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 判断是否运行在主进程
     */
    static boolean isMainProcess() {
        return ProcessUtils.isMainProcess();
    }

    /**
     * 获取前台线程包名
     */
    static String getForegroundProcessName() {
        return ProcessUtils.getForegroundProcessName();
    }

    /**
     * 获取当前进程名称
     */
    static String getCurrentProcessName() {
        return ProcessUtils.getCurrentProcessName();
    }

    ///////////////////////////////////////////////////////////////////////////
    // RomUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 是否三星
     */
    public static boolean isSamsung() {
        return RomUtils.isSamsung();
    }

    ///////////////////////////////////////////////////////////////////////////
    // ScreenUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 获取应用屏幕的宽度（单位：px）
     */
    static int getAppScreenWidth() {
        return ScreenUtils.getAppScreenWidth();
    }

    ///////////////////////////////////////////////////////////////////////////
    // SDCardUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 根据 Environment 判断 SD 卡是否可用
     */
    public static boolean isSDCardEnableByEnvironment() {
        return SDCardUtils.isSDCardEnableByEnvironment();
    }

    ///////////////////////////////////////////////////////////////////////////
    // ServiceUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 判断服务是否运行
     */
    public static boolean isServiceRunning(final String className) {
        return ServiceUtils.isServiceRunning(className);
    }

    ///////////////////////////////////////////////////////////////////////////
    // ShellUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 执行命令
     */
    static ShellUtils.CommandResult execCmd(final String command, final boolean isRooted) {
        return ShellUtils.execCmd(command, isRooted);
    }

    ///////////////////////////////////////////////////////////////////////////
    // SizeUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * dp 转 px
     */
    static int dp2px(final float dpValue) {
        return SizeUtils.dp2px(dpValue);
    }

    /**
     * px 转 dp
     */
    static int px2dp(final float pxValue) {
        return SizeUtils.px2dp(pxValue);
    }

    /**
     * sp 转 px
     */
    static int sp2px(final float spValue) {
        return SizeUtils.sp2px(spValue);
    }

    /**
     * px 转 sp
     */
    static int px2sp(final float pxValue) {
        return SizeUtils.px2sp(pxValue);
    }

    ///////////////////////////////////////////////////////////////////////////
    // SpUtils
    ///////////////////////////////////////////////////////////////////////////

    static SPUtils getSpUtils4Utils() {
        return SPUtils.getInstance("Utils");
    }

    ///////////////////////////////////////////////////////////////////////////
    // StringUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 判断字符串是否为 null 或全为空白字符
     */
    public static boolean isSpace(final String s) {
        return StringUtils.isSpace(s);
    }

    /**
     * 判断两字符串是否相等
     */
    static boolean equals(final CharSequence s1, final CharSequence s2) {
        return StringUtils.equals(s1, s2);
    }

    /**
     * 获取字符资源
     */
    static String getString(@StringRes int id) {
        return StringUtils.getString(id);
    }

    /**
     * 获取字符资源
     */
    static String getString(@StringRes int id, Object... formatArgs) {
        return StringUtils.getString(id, formatArgs);
    }

    /**
     * 格式化字符串
     */
    static String format(@Nullable String str, Object... args) {
        return StringUtils.format(str, args);
    }

    ///////////////////////////////////////////////////////////////////////////
    // ThreadUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 异步执行任务
     */
    static <T> Utils.Task<T> doAsync(final Utils.Task<T> task) {
        ThreadUtils.getCachedPool().execute(task);
        return task;
    }

    /**
     * 运行在主线程
     */
    static void runOnUiThread(final Runnable runnable) {
        ThreadUtils.runOnUiThread(runnable);
    }

    /**
     * 延时运行在主线程
     */
    static void runOnUiThreadDelayed(final Runnable runnable, long delayMillis) {
        ThreadUtils.runOnUiThreadDelayed(runnable, delayMillis);
    }

    ///////////////////////////////////////////////////////////////////////////
    // ThrowableUtils
    ///////////////////////////////////////////////////////////////////////////

    static String getFullStackTrace(Throwable throwable) {
        return ThrowableUtils.getFullStackTrace(throwable);
    }

    ///////////////////////////////////////////////////////////////////////////
    // TimeUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 毫秒时间戳转合适时间长度
     */
    static String millis2FitTimeSpan(long millis, int precision) {
        return TimeUtils.millis2FitTimeSpan(millis, precision);
    }

    ///////////////////////////////////////////////////////////////////////////
    // ToastUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 显示短时吐司
     */
    static void toastShowShort(final CharSequence text) {
        ToastUtils.showShort(text);
    }

    /**
     * 取消吐司显示
     */
    static void toastCancel() {
        ToastUtils.cancel();
    }

    ///////////////////////////////////////////////////////////////////////////
    // UriUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * file 转 uri
     */
    static Uri file2Uri(final File file) {
        return UriUtils.file2Uri(file);
    }

    /**
     * uri 转 file
     */
    static File uri2File(final Uri uri) {
        return UriUtils.uri2File(uri);
    }

    ///////////////////////////////////////////////////////////////////////////
    // ViewUtils
    ///////////////////////////////////////////////////////////////////////////

    /**
     * layoutId 转为 view
     */
    static View layoutId2View(@LayoutRes final int layoutId) {
        return ViewUtils.layoutId2View(layoutId);
    }

    /**
     * 布局是否从右到左
     */
    static boolean isLayoutRtl() {
        return ViewUtils.isLayoutRtl();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Common
    ///////////////////////////////////////////////////////////////////////////

    static final class FileHead {

        private String mName;
        private LinkedHashMap<String, String> mFirst = new LinkedHashMap<>();
        private LinkedHashMap<String, String> mLast = new LinkedHashMap<>();

        FileHead(String name) {
            mName = name;
        }

        void addFirst(String key, String value) {
            append2Host(mFirst, key, value);
        }

        void append(Map<String, String> extra) {
            append2Host(mLast, extra);
        }

        void append(String key, String value) {
            append2Host(mLast, key, value);
        }

        private void append2Host(Map<String, String> host, Map<String, String> extra) {
            if (extra == null || extra.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry : extra.entrySet()) {
                append2Host(host, entry.getKey(), entry.getValue());
            }
        }

        private void append2Host(Map<String, String> host, String key, String value) {
            if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
                return;
            }
            int delta = 19 - key.length(); // 19 is length of "Device Manufacturer"
            if (delta > 0) {
                key = key + "                   ".substring(0, delta);
            }
            host.put(key, value);
        }

        public String getAppended() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : mLast.entrySet()) {
                sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            return sb.toString();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String border = "************* " + mName + " Head ****************\n";
            sb.append(border);
            for (Map.Entry<String, String> entry : mFirst.entrySet()) {
                sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }

            sb.append("Rom Info           : ").append(RomUtils.getRomInfo()).append("\n");
            sb.append("Device Manufacturer: ").append(Build.MANUFACTURER).append("\n");
            sb.append("Device Model       : ").append(Build.MODEL).append("\n");
            sb.append("Android Version    : ").append(Build.VERSION.RELEASE).append("\n");
            sb.append("Android SDK        : ").append(Build.VERSION.SDK_INT).append("\n");
            sb.append("App VersionName    : ").append(AppUtils.getAppVersionName()).append("\n");
            sb.append("App VersionCode    : ").append(AppUtils.getAppVersionCode()).append("\n");

            sb.append(getAppended());
            return sb.append(border).append("\n").toString();
        }
    }
}
