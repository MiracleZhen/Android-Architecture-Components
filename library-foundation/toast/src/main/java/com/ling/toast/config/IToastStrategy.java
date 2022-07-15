package com.ling.toast.config;

import android.app.Application;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/ToastUtils
 * time   : 2022/5/19
 * desc   : Toast 处理策略
 */
public interface IToastStrategy {

    /**
     * 注册策略
     */
    void registerStrategy(Application application);

    /**
     * 绑定样式
     */
    void bindStyle(IToastStyle<?> style);

    /**
     * 创建 Toast
     */
    IToast createToast(Application application);

    /**
     * 显示 Toast
     */
    void showToast(CharSequence text, long delayMillis);

    /**
     * 取消 Toast
     */
    void cancelToast();
}
