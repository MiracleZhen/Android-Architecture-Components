package com.ling.http.config;

import androidx.annotation.NonNull;

import com.ling.http.annotation.HttpIgnore;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/EasyHttp
 * time   : 2022/5/19
 * desc   : 服务器简单配置
 */
public final class RequestServer implements IRequestServer {

    /** 主机地址 */
    @HttpIgnore
    private final String mHost;

    public RequestServer(String host) {
        mHost = host;
    }

    @NonNull
    @Override
    public String getHost() {
        return mHost;
    }

    @NonNull
    @Override
    public String toString() {
        return mHost;
    }
}
