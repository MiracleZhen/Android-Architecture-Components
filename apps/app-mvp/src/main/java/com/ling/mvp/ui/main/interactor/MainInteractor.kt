package com.ling.mvp.ui.main.interactor

import com.ling.mvp.data.database.repository.options.Option
import com.ling.mvp.data.database.repository.options.OptionRepo
import com.ling.mvp.data.database.repository.questions.Question
import com.ling.mvp.data.database.repository.questions.QuestionRepo
import com.ling.mvp.data.network.ApiHelper
import com.ling.mvp.data.network.model.LogoutResponse
import com.ling.mvp.data.preferences.PreferenceHelper
import com.ling.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : MainInteractor
 */
class MainInteractor @Inject internal constructor(
    private val questionRepoHelper: QuestionRepo,
    private val optionRepoHelper: OptionRepo,
    prefHelper: PreferenceHelper,
    apiHelper: ApiHelper)
    : BaseInteractor(prefHelper, apiHelper), MainMvpInteractor {

    override fun getQuestionCardData(): Single<List<QuestionCardData>> {
        return questionRepoHelper.loadQuestions()
            .flatMapIterable { question -> question }
            .flatMapSingle { question -> getQuestionCards(question) }
            .toList()
    }

    override fun getUserDetails(): Pair<String?, String?> {
        return Pair(prefHelper.getCurrentUserName(), prefHelper.getCurrentUserEmail())
    }

    override fun makeLogoutApiCall(): Observable<LogoutResponse> {
        return apiHelper.performLogoutApiCall()
    }

    private fun getQuestionCards(question: Question) = optionRepoHelper.loadOptions(question.id)
        .map { options -> createQuestionCard(options, question) }

    private fun createQuestionCard(options: List<Option>, question: Question) =
        QuestionCardData(options, question)
}
