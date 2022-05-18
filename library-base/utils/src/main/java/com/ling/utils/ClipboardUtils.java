package com.ling.utils;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;

/**
 * author : wangchengzhen
 * github : https://github.com/Blankj/AndroidUtilCode
 * time   : 2021/11/12
 * desc   : utils about clipboard - 剪贴板相关
 */
public final class ClipboardUtils {

    private ClipboardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 复制文本到剪贴板
     * <p>
     * Copy the text to clipboard.
     * <p>The label equals name of package.</p>
     *
     * @param text The text.
     */
    public static void copyText(final CharSequence text) {
        ClipboardManager cm = (ClipboardManager) Utils.getApp().getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        cm.setPrimaryClip(ClipData.newPlainText(Utils.getApp().getPackageName(), text));
    }

    /**
     * 复制文本到剪贴板
     * <p>
     * Copy the text to clipboard.
     *
     * @param label The label.
     * @param text  The text.
     */
    public static void copyText(final CharSequence label, final CharSequence text) {
        ClipboardManager cm = (ClipboardManager) Utils.getApp().getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        cm.setPrimaryClip(ClipData.newPlainText(label, text));
    }

    /**
     * Clear the clipboard.
     */
    public static void clear() {
        ClipboardManager cm = (ClipboardManager) Utils.getApp().getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        cm.setPrimaryClip(ClipData.newPlainText(null, ""));
    }

    /**
     * Return the label for clipboard.
     *
     * @return the label for clipboard
     */
    public static CharSequence getLabel() {
        ClipboardManager cm = (ClipboardManager) Utils.getApp().getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        ClipDescription des = cm.getPrimaryClipDescription();
        if (des == null) {
            return "";
        }
        CharSequence label = des.getLabel();
        if (label == null) {
            return "";
        }
        return label;
    }

    /**
     * 获取剪贴板的文本
     * <p>
     * Return the text for clipboard.
     *
     * @return the text for clipboard
     */
    public static CharSequence getText() {
        ClipboardManager cm = (ClipboardManager) Utils.getApp().getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        ClipData clip = cm.getPrimaryClip();
        if (clip != null && clip.getItemCount() > 0) {
            CharSequence text = clip.getItemAt(0).coerceToText(Utils.getApp());
            if (text != null) {
                return text;
            }
        }
        return "";
    }

    /**
     * 增加剪贴板监听器
     * <p>
     * Add the clipboard changed listener.
     */
    public static void addChangedListener(final ClipboardManager.OnPrimaryClipChangedListener listener) {
        ClipboardManager cm = (ClipboardManager) Utils.getApp().getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        cm.addPrimaryClipChangedListener(listener);
    }

    /**
     * 移除剪贴板监听器
     * <p>
     * Remove the clipboard changed listener.
     */
    public static void removeChangedListener(final ClipboardManager.OnPrimaryClipChangedListener listener) {
        ClipboardManager cm = (ClipboardManager) Utils.getApp().getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        cm.removePrimaryClipChangedListener(listener);
    }
}
