package com.ling.mvp.ui.base.presenter

import com.ling.mvp.ui.base.interactor.MvpInteractor
import com.ling.mvp.ui.base.view.MvpView

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : MvpPresenter
 */
interface MvpPresenter<V : MvpView, I : MvpInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?
}
