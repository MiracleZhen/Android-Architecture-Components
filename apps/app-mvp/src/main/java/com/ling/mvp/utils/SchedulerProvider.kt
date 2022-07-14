package com.ling.mvp.utils

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : SchedulerProvider
 */
class SchedulerProvider {

    /**
     * IO 线程 -> 主线程
     */
    fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T> =
        ObservableTransformer { upstream ->
            upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
        }

    fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T> = SingleTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }

    fun ioToMainCompletableScheduler(): CompletableTransformer =
        CompletableTransformer { upstream ->
            upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
        }

    fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T> =
        FlowableTransformer { upstream ->
            upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
        }

    fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T> = MaybeTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }

    /** IO 线程调度 */
    private fun getIOThreadScheduler() = Schedulers.io()

    /** 主线程调度 */
    private fun getMainThreadScheduler() = AndroidSchedulers.mainThread()
}
