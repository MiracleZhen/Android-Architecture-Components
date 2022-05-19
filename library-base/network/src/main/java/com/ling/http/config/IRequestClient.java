package com.ling.http.config;

import androidx.annotation.NonNull;

import com.ling.http.EasyConfig;

import okhttp3.OkHttpClient;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/EasyHttp
 * time   : 2022/5/19
 * desc   : OkHttpClient 配置
 */
public interface IRequestClient {

    /**
     * 获取 OkHttpClient
     */
    @NonNull
    default OkHttpClient getOkHttpClient() {
        return EasyConfig.getInstance().getClient();
    }
}
