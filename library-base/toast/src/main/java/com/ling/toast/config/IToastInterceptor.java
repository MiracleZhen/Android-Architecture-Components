package com.ling.toast.config;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/ToastUtils
 * time   : 2022/5/19
 * desc   : Toast 拦截器接口
 */
public interface IToastInterceptor {

    /**
     * 根据显示的文本决定是否拦截该 Toast
     */
    boolean intercept(CharSequence text);
}
