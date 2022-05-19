package com.ling.http.request;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import com.ling.http.model.HttpMethod;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/EasyHttp
 * time   : 2022/5/19
 * desc   : Delete 请求
 * doc    : Delete 请求该用 Url 还是 Body 来传递参数：
 *          https://stackoverflow.com/questions/299628/is-an-entity-body-allowed-for-an-http-delete-request
 */
public final class DeleteRequest extends UrlRequest<DeleteRequest> {

    public DeleteRequest(LifecycleOwner lifecycleOwner) {
        super(lifecycleOwner);
    }

    @NonNull
    @Override
    public String getRequestMethod() {
        return HttpMethod.DELETE.toString();
    }
}
