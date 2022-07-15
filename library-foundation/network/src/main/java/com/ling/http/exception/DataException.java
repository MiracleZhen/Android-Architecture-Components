package com.ling.http.exception;

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/EasyHttp
 * time   : 2022/5/19
 * desc   : 数据解析异常
 */
public final class DataException extends HttpException {

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }
}
