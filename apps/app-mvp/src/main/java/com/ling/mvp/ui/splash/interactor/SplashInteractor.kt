package com.ling.mvp.ui.splash.interactor

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.internal.`$Gson$Types`
import com.ling.mvp.app.AppConstants
import com.ling.mvp.data.database.repository.options.Option
import com.ling.mvp.data.database.repository.options.OptionRepo
import com.ling.mvp.data.database.repository.questions.Question
import com.ling.mvp.data.database.repository.questions.QuestionRepo
import com.ling.mvp.data.network.ApiHelper
import com.ling.mvp.data.preferences.PreferenceHelper
import com.ling.mvp.ui.base.interactor.BaseInteractor
import com.ling.mvp.utils.FileUtils
import io.reactivex.Observable
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : SplashInteractor
 */
class SplashInteractor @Inject constructor(
    private val context: Context,
    private val questionRepoHelper: QuestionRepo,
    private val optionRepoHelper: OptionRepo,
    prefHelper: PreferenceHelper,
    apiHelper: ApiHelper) : BaseInteractor(prefHelper, apiHelper), SplashMvpInteractor {

    override fun seedQuestions(): Observable<Boolean> {
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()
        return questionRepoHelper.isQuestionsRepoEmpty().concatMap { isEmpty ->
            if (isEmpty) {
                val type = `$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Question::class.java)
                val questionList = gson.fromJson<List<Question>>(
                    FileUtils.loadJSONFromAsset(context, AppConstants.SEED_DATABASE_QUESTIONS),
                    type
                )
                questionRepoHelper.insertQuestions(questionList)
            } else {
                Observable.just(false)
            }
        }
    }

    override fun seedOptions(): Observable<Boolean> {
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()
        return optionRepoHelper.isOptionsRepoEmpty().concatMap { isEmpty ->
            if (isEmpty) {
                val type = `$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Option::class.java)
                val optionList = gson.fromJson<List<Option>>(
                    FileUtils.loadJSONFromAsset(context, AppConstants.SEED_DATABASE_OPTIONS),
                    type
                )
                optionRepoHelper.insertOptions(optionList)
            } else {
                Observable.just(false)
            }
        }
    }

    override fun getQuestion(): Observable<List<Question>> {
        return questionRepoHelper.loadQuestions()
    }
}
