package com.ling.utils.resource;

import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;
import androidx.annotation.RawRes;
import androidx.core.content.ContextCompat;

import com.ling.utils.Utils;
import com.ling.utils.UtilsBridge;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

/**
 * author : wangchengzhen
 * github : https://github.com/Blankj/AndroidUtilCode
 * time   : 2021/11/14
 * desc   : utils about resource - 资源相关
 */
public final class ResourceUtils {

    private static final int BUFFER_SIZE = 8192;

    private ResourceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 获取 Drawable
     * <p>
     * Return the drawable by identifier.
     *
     * @param id The identifier.
     * @return the drawable by identifier
     */
    public static Drawable getDrawable(@DrawableRes int id) {
        return ContextCompat.getDrawable(Utils.getApp(), id);
    }

    /**
     * 根据名字获取 ID
     * <p>
     * Return the id identifier by name.
     *
     * @param name The name of id.
     * @return the id identifier by name
     */
    public static int getIdByName(String name) {
        return Utils.getApp().getResources().getIdentifier(name, "id", Utils.getApp().getPackageName());
    }

    /**
     * 根据名字获取 string ID
     * <p>
     * Return the string identifier by name.
     *
     * @param name The name of string.
     * @return the string identifier by name
     */
    public static int getStringIdByName(String name) {
        return Utils.getApp().getResources().getIdentifier(name, "string", Utils.getApp().getPackageName());
    }

    /**
     * 根据名字获取 color ID
     * <p>
     * Return the color identifier by name.
     *
     * @param name The name of color.
     * @return the color identifier by name
     */
    public static int getColorIdByName(String name) {
        return Utils.getApp().getResources().getIdentifier(name, "color", Utils.getApp().getPackageName());
    }

    /**
     * 根据名字获取 dimen ID
     * <p>
     * Return the dimen identifier by name.
     *
     * @param name The name of dimen.
     * @return the dimen identifier by name
     */
    public static int getDimenIdByName(String name) {
        return Utils.getApp().getResources().getIdentifier(name, "dimen", Utils.getApp().getPackageName());
    }

    /**
     * 根据名字获取 dimen ID
     * <p>
     * Return the drawable identifier by name.
     *
     * @param name The name of drawable.
     * @return the drawable identifier by name
     */
    public static int getDrawableIdByName(String name) {
        return Utils.getApp().getResources().getIdentifier(name, "drawable", Utils.getApp().getPackageName());
    }

    /**
     * 根据名字获取 mipmap ID
     * <p>
     * Return the mipmap identifier by name.
     *
     * @param name The name of mipmap.
     * @return the mipmap identifier by name
     */
    public static int getMipmapIdByName(String name) {
        return Utils.getApp().getResources().getIdentifier(name, "mipmap", Utils.getApp().getPackageName());
    }

    /**
     * 根据名字获取 layout ID
     * <p>
     * Return the layout identifier by name.
     *
     * @param name The name of layout.
     * @return the layout identifier by name
     */
    public static int getLayoutIdByName(String name) {
        return Utils.getApp().getResources().getIdentifier(name, "layout", Utils.getApp().getPackageName());
    }

    /**
     * 根据名字获取 style ID
     * <p>
     * Return the style identifier by name.
     *
     * @param name The name of style.
     * @return the style identifier by name
     */
    public static int getStyleIdByName(String name) {
        return Utils.getApp().getResources().getIdentifier(name, "style", Utils.getApp().getPackageName());
    }

    /**
     * 根据名字获取 anim ID
     * <p>
     * Return the anim identifier by name.
     *
     * @param name The name of anim.
     * @return the anim identifier by name
     */
    public static int getAnimIdByName(String name) {
        return Utils.getApp().getResources().getIdentifier(name, "anim", Utils.getApp().getPackageName());
    }

    /**
     * 根据名字获取 menu ID
     * <p>
     * Return the menu identifier by name.
     *
     * @param name The name of menu.
     * @return the menu identifier by name
     */
    public static int getMenuIdByName(String name) {
        return Utils.getApp().getResources().getIdentifier(name, "menu", Utils.getApp().getPackageName());
    }

    /**
     * 从 assets 中拷贝文件
     * <p>
     * Copy the file from assets.
     *
     * @param assetsFilePath The path of file in assets.
     * @param destFilePath   The path of destination file.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean copyFileFromAssets(final String assetsFilePath, final String destFilePath) {
        boolean res = true;
        try {
            String[] assets = Utils.getApp().getAssets().list(assetsFilePath);
            if (assets != null && assets.length > 0) {
                for (String asset : assets) {
                    res &= copyFileFromAssets(assetsFilePath + "/" + asset, destFilePath + "/" + asset);
                }
            } else {
                res = UtilsBridge.writeFileFromIS(
                        destFilePath,
                        Utils.getApp().getAssets().open(assetsFilePath)
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
            res = false;
        }
        return res;
    }

    /**
     * 从 assets 中读取字符串
     * <p>
     * Return the content of assets.
     *
     * @param assetsFilePath The path of file in assets.
     * @return the content of assets
     */
    public static String readAssets2String(final String assetsFilePath) {
        return readAssets2String(assetsFilePath, null);
    }

    /**
     * 从 assets 中读取字符串
     * <p>
     * Return the content of assets.
     *
     * @param assetsFilePath The path of file in assets.
     * @param charsetName    The name of charset.
     * @return the content of assets
     */
    public static String readAssets2String(final String assetsFilePath, final String charsetName) {
        try {
            InputStream is = Utils.getApp().getAssets().open(assetsFilePath);
            byte[] bytes = UtilsBridge.inputStream2Bytes(is);
            if (bytes == null) return "";
            if (UtilsBridge.isSpace(charsetName)) {
                return new String(bytes);
            } else {
                try {
                    return new String(bytes, charsetName);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 从 assets 中按行读取字符串
     * <p>
     * Return the content of file in assets.
     *
     * @param assetsPath The path of file in assets.
     * @return the content of file in assets
     */
    public static List<String> readAssets2List(final String assetsPath) {
        return readAssets2List(assetsPath, "");
    }

    /**
     * 从 assets 中按行读取字符串
     * <p>
     * Return the content of file in assets.
     *
     * @param assetsPath  The path of file in assets.
     * @param charsetName The name of charset.
     * @return the content of file in assets
     */
    public static List<String> readAssets2List(final String assetsPath,
                                               final String charsetName) {
        try {
            return UtilsBridge.inputStream2Lines(Utils.getApp().getResources().getAssets().open(assetsPath), charsetName);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    /**
     * 从 raw 中拷贝文件
     * <p>
     * Copy the file from raw.
     *
     * @param resId        The resource id.
     * @param destFilePath The path of destination file.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean copyFileFromRaw(@RawRes final int resId, final String destFilePath) {
        return UtilsBridge.writeFileFromIS(
                destFilePath,
                Utils.getApp().getResources().openRawResource(resId)
        );
    }

    /**
     * 从 raw 中读取字符串
     * <p>
     * Return the content of resource in raw.
     *
     * @param resId The resource id.
     * @return the content of resource in raw
     */
    public static String readRaw2String(@RawRes final int resId) {
        return readRaw2String(resId, null);
    }

    /**
     * 从 raw 中读取字符串
     * <p>
     * Return the content of resource in raw.
     *
     * @param resId       The resource id.
     * @param charsetName The name of charset.
     * @return the content of resource in raw
     */
    public static String readRaw2String(@RawRes final int resId, final String charsetName) {
        InputStream is = Utils.getApp().getResources().openRawResource(resId);
        byte[] bytes = UtilsBridge.inputStream2Bytes(is);
        if (bytes == null) return null;
        if (UtilsBridge.isSpace(charsetName)) {
            return new String(bytes);
        } else {
            try {
                return new String(bytes, charsetName);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    /**
     * 从 raw 中按行读取字符串
     * <p>
     * Return the content of resource in raw.
     *
     * @param resId The resource id.
     * @return the content of file in assets
     */
    public static List<String> readRaw2List(@RawRes final int resId) {
        return readRaw2List(resId, "");
    }

    /**
     * 从 raw 中按行读取字符串
     * <p>
     * Return the content of resource in raw.
     *
     * @param resId       The resource id.
     * @param charsetName The name of charset.
     * @return the content of file in assets
     */
    public static List<String> readRaw2List(@RawRes final int resId,
                                            final String charsetName) {
        return UtilsBridge.inputStream2Lines(Utils.getApp().getResources().openRawResource(resId), charsetName);
    }
}
