package com.ling.http.config;

import androidx.annotation.NonNull;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/EasyHttp
 * time   : 2022/5/19
 * desc   : 请求接口配置
 */
public interface IRequestApi {

    /**
     * 请求接口
     */
    @NonNull
    String getApi();
}
