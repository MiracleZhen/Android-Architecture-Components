package com.ling.mvp.ui.main.interactor

import com.ling.mvp.data.database.repository.options.Option
import com.ling.mvp.data.database.repository.questions.Question

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : QuestionCardData
 */
data class QuestionCardData(
    val option: List<Option>,
    val question: Question
)
