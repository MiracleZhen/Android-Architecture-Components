package com.ling.mvp.ui.main.view

import android.graphics.Color
import android.widget.Button
import android.widget.TextView
import com.androidnetworking.widget.ANImageView
import com.ling.mvp.R
import com.ling.mvp.ui.main.interactor.QuestionCardData
import com.mindorks.placeholderview.annotations.*

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : QuestionCardView
 */
@NonReusable
@Layout(R.layout.card_layout)
class QuestionCardView(private val question: QuestionCardData) {

    @View(R.id.iv_pic)
    private lateinit var picImageView: ANImageView

    @View(R.id.tv_question_txt)
    private lateinit var questionTextView: TextView

    @View(R.id.btn_option_1)
    private lateinit var option1Button: Button

    @View(R.id.btn_option_2)
    private lateinit var option2Button: Button

    @View(R.id.btn_option_3)
    private lateinit var option3Button: Button

    @Click(R.id.btn_option_1)
    internal fun onOption1Click() {
        showCorrectOptions()
    }

    @Click(R.id.btn_option_2)
    internal fun onOption2Click() {
        showCorrectOptions()
    }

    @Click(R.id.btn_option_3)
    internal fun onOption3Click() {
        showCorrectOptions()
    }

    @Resolve
    private fun onResolved() {
        questionTextView.text = question.question.questionText
        for (i in 0..2) {
            var button: Button? = null
            when (i) {
                0 -> button = option1Button
                1 -> button = option2Button
                2 -> button = option3Button
            }
            button?.text = question.option[i].optionText
            question.question.imgUrl?.let { picImageView.setImageUrl(it) }
        }
    }

    private fun showCorrectOptions() {
        for (i in 0..2) {
            val option = question.option[i]
            var button: Button? = null
            when (i) {
                0 -> button = option1Button
                1 -> button = option2Button
                2 -> button = option3Button
            }
            button?.apply {
                setBackgroundColor(if (option.isCorrect) Color.GREEN else Color.RED)
            }
        }
    }
}
