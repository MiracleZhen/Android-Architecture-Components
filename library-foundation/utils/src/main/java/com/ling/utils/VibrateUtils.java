package com.ling.utils;

import android.content.Context;
import android.os.Vibrator;

import androidx.annotation.RequiresPermission;

import static android.Manifest.permission.VIBRATE;

/**
 * author : wangchengzhen
 * github : https://github.com/Blankj/AndroidUtilCode
 * time   : 2021/11/12
 * desc   : utils about vibrate - 震动相关
 */
public final class VibrateUtils {

    private static Vibrator vibrator;

    private VibrateUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 震动
     * <p>
     * Vibrate.
     * <p>Must hold {@code <uses-permission android:name="android.permission.VIBRATE" />}</p>
     *
     * @param milliseconds The number of milliseconds to vibrate.
     */
    @RequiresPermission(VIBRATE)
    public static void vibrate(final long milliseconds) {
        Vibrator vibrator = getVibrator();
        if (vibrator == null) return;
        vibrator.vibrate(milliseconds);
    }

    /**
     * 震动
     * <p>
     * Vibrate.
     * <p>Must hold {@code <uses-permission android:name="android.permission.VIBRATE" />}</p>
     *
     * @param pattern An array of longs of times for which to turn the vibrator on or off.
     * @param repeat  The index into pattern at which to repeat, or -1 if you don't want to repeat.
     */
    @RequiresPermission(VIBRATE)
    public static void vibrate(final long[] pattern, final int repeat) {
        Vibrator vibrator = getVibrator();
        if (vibrator == null) return;
        vibrator.vibrate(pattern, repeat);
    }

    /**
     * 取消
     * <p>
     * Cancel vibrate.
     * <p>Must hold {@code <uses-permission android:name="android.permission.VIBRATE" />}</p>
     */
    @RequiresPermission(VIBRATE)
    public static void cancel() {
        Vibrator vibrator = getVibrator();
        if (vibrator == null) return;
        vibrator.cancel();
    }

    private static Vibrator getVibrator() {
        if (vibrator == null) {
            vibrator = (Vibrator) Utils.getApp().getSystemService(Context.VIBRATOR_SERVICE);
        }
        return vibrator;
    }
}
