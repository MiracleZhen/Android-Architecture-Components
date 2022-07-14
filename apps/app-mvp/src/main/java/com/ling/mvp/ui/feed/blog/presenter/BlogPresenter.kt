package com.ling.mvp.ui.feed.blog.presenter

import com.ling.mvp.ui.base.presenter.BasePresenter
import com.ling.mvp.ui.feed.blog.interactor.BlogMvpInteractor
import com.ling.mvp.ui.feed.blog.view.BlogMvpView
import com.ling.mvp.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : BlogPresenter
 */
class BlogPresenter<V : BlogMvpView, I : BlogMvpInteractor> @Inject constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, schedulerProvider, disposable), BlogMvpPresenter<V, I> {

    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {
            it.getBlogList()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({ blogResponse ->
                    getView()?.let { v ->
                        v.hideProgress()
                        v.displayBlogList(blogResponse.data)
                    }
                }, { error ->
                    println(error)
                    getView()?.hideProgress()
                })
        }
    }
}
