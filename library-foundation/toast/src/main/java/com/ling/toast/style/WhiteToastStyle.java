package com.ling.toast.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/ToastUtils
 * time   : 2022/5/19
 * desc   : 默认白色样式实现
 */
public class WhiteToastStyle extends BlackToastStyle {

    @Override
    protected int getTextColor(Context context) {
        return 0XBB000000;
    }

    @Override
    protected Drawable getBackgroundDrawable(Context context) {
        GradientDrawable drawable = new GradientDrawable();
        // 设置颜色
        drawable.setColor(0XFFEAEAEA);
        // 设置圆角
        drawable.setCornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, context.getResources().getDisplayMetrics()));
        return drawable;
    }
}
