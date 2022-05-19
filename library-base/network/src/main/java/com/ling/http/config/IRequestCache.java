package com.ling.http.config;

import androidx.annotation.NonNull;

import com.ling.http.model.CacheMode;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/EasyHttp
 * time   : 2022/5/19
 * desc   : 请求缓存配置
 */
public interface IRequestCache {

    /**
     * 获取缓存的模式
     */
    @NonNull
    CacheMode getCacheMode();

    /**
     * 获取缓存的有效时长（以毫秒为单位）
     */
    long getCacheTime();
}
