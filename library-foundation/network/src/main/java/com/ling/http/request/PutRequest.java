package com.ling.http.request;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import com.ling.http.model.HttpMethod;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/EasyHttp
 * time   : 2022/5/19
 * desc   : Put 请求
 */
public final class PutRequest extends BodyRequest<PutRequest> {

    public PutRequest(LifecycleOwner lifecycleOwner) {
        super(lifecycleOwner);
    }

    @NonNull
    @Override
    public String getRequestMethod() {
        return HttpMethod.PUT.toString();
    }
}
