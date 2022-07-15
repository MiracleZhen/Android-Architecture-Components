package com.ling.http.config;

import androidx.annotation.NonNull;

import com.ling.http.annotation.HttpIgnore;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/EasyHttp
 * time   : 2022/5/19
 * desc   : 请求接口简单配置类
 */
public class RequestApi implements IRequestApi {

    /** 接口地址 */
    @HttpIgnore
    private final String mApi;

    public RequestApi(String api) {
        mApi = api;
    }

    @NonNull
    @Override
    public String getApi() {
        return mApi;
    }

    @NonNull
    @Override
    public String toString() {
        return mApi;
    }
}
