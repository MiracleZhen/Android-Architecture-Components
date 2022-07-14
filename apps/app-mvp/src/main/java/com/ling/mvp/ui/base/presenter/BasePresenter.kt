package com.ling.mvp.ui.base.presenter

import com.ling.mvp.ui.base.interactor.MvpInteractor
import com.ling.mvp.ui.base.view.MvpView
import com.ling.mvp.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : BasePresenter
 */
abstract class BasePresenter<V : MvpView, I : MvpInteractor> internal constructor(
    protected var interactor: I?,
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable) : MvpPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean
        get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

    override fun getView(): V? {
        return view
    }
}
