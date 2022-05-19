package com.ling.bar.style;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.ling.bar.R;
import com.ling.bar.SelectorDrawable;
import com.ling.bar.TitleBarSupport;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/TitleBar
 * time   : 2022/5/19
 * desc   : 日间主题样式实现（对应布局属性：app:barStyle="light"）
 */
public class LightBarStyle extends CommonBarStyle {

    @Override
    public Drawable getTitleBarBackground(Context context) {
        return new ColorDrawable(0xFFFFFFFF);
    }

    @Override
    public Drawable getLeftTitleBackground(Context context) {
        return new SelectorDrawable.Builder()
                .setDefault(new ColorDrawable(0x00000000))
                .setFocused(new ColorDrawable(0x0C000000))
                .setPressed(new ColorDrawable(0x0C000000))
                .build();
    }

    @Override
    public Drawable getRightTitleBackground(Context context) {
        return new SelectorDrawable.Builder()
                .setDefault(new ColorDrawable(0x00000000))
                .setFocused(new ColorDrawable(0x0C000000))
                .setPressed(new ColorDrawable(0x0C000000))
                .build();
    }

    @Override
    public Drawable getBackButtonDrawable(Context context) {
        return TitleBarSupport.getDrawable(context, R.drawable.bar_arrows_left_black);
    }

    @Override
    public ColorStateList getTitleColor(Context context) {
        return ColorStateList.valueOf(0xFF222222);
    }

    @Override
    public ColorStateList getLeftTitleColor(Context context) {
        return ColorStateList.valueOf(0xFF666666);
    }

    @Override
    public ColorStateList getRightTitleColor(Context context) {
        return ColorStateList.valueOf(0xFFA4A4A4);
    }

    @Override
    public Drawable getLineDrawable(Context context) {
        return new ColorDrawable(0xFFECECEC);
    }
}
