package com.ling.http.config;

import androidx.annotation.NonNull;

import com.ling.http.model.BodyType;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/EasyHttp
 * time   : 2022/5/19
 * desc   : 请求接口配置
 */
public interface IRequestType {

    /**
     * 获取参数的提交类型
     */
    @NonNull
    BodyType getBodyType();
}
