package com.ling.mvp.ui.feed.opensource

import androidx.recyclerview.widget.LinearLayoutManager
import com.ling.mvp.ui.feed.opensource.interactor.OpenSourceInteractor
import com.ling.mvp.ui.feed.opensource.interactor.OpenSourceMvpInteractor
import com.ling.mvp.ui.feed.opensource.presenter.OpenSourceMvpPresenter
import com.ling.mvp.ui.feed.opensource.presenter.OpenSourcePresenter
import com.ling.mvp.ui.feed.opensource.view.OpenSourceAdapter
import com.ling.mvp.ui.feed.opensource.view.OpenSourceFragment
import com.ling.mvp.ui.feed.opensource.view.OpenSourceMvpView
import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : OpenSourceFragmentModule
 */
@Module
class OpenSourceFragmentModule {

    @Provides
    internal fun provideOpenSourceInteractor(interactor: OpenSourceInteractor): OpenSourceMvpInteractor =
        interactor

    @Provides
    internal fun provideOpenSourcePresenter(presenter: OpenSourcePresenter<OpenSourceMvpView, OpenSourceMvpInteractor>)
            : OpenSourceMvpPresenter<OpenSourceMvpView, OpenSourceMvpInteractor> = presenter

    @Provides
    internal fun provideOpenSourceAdapter(): OpenSourceAdapter = OpenSourceAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: OpenSourceFragment): LinearLayoutManager =
        LinearLayoutManager(fragment.activity)
}
