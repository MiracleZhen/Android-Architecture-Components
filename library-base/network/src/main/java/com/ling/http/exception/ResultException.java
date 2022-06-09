package com.ling.http.exception;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/EasyHttp
 * time   : 2022/6/8
 * desc   : 返回结果异常
 */
public final class ResultException extends HttpException {

    private final Object mData;

    public ResultException(String message, Object data) {
        super(message);
        mData = data;
    }

    public ResultException(String message, Throwable cause, Object data) {
        super(message, cause);
        mData = data;
    }

    public Object getData() {
        return mData;
    }
}
