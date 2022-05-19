package com.ling.bar;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/TitleBar
 * time   : 2022/5/19
 * desc   : 标题栏点击监听接口
 */
public interface OnTitleBarListener {

    /**
     * 左项被点击
     */
    default void onLeftClick(TitleBar titleBar) {
    }

    /**
     * 标题被点击
     */
    default void onTitleClick(TitleBar titleBar) {
    }

    /**
     * 右项被点击
     */
    default void onRightClick(TitleBar titleBar) {
    }
}
