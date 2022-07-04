package com.ling.coroutine.download

import java.io.File

/**
 * author : wangchengzhen
 * time   : 2022/7/4
 * desc   : 定义一些记录下载状态的类
 */
sealed class DownloadState {

    /**
     * InProgress 用于回调下载进度
     */
    data class InProgress(val progress: Int) : DownloadState()

    /**
     * Success 表示下载成功
     */
    data class Success(val file: File) : DownloadState()

    /**
     * Error 表示下载失败
     */
    data class Error(val throwable: Throwable) : DownloadState()
}
