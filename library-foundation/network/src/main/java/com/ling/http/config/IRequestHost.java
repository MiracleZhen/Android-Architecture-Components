package com.ling.http.config;

import androidx.annotation.NonNull;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/EasyHttp
 * time   : 2022/5/19
 * desc   : 请求主机配置
 */
public interface IRequestHost {

    /**
     * 主机地址
     */
    @NonNull
    String getHost();
}
