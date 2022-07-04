package com.ling.coroutine.type01.p1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ling.coroutine.api.repository.ArticleRepository
import kotlinx.coroutines.launch

/**
 * author : wangchengzhen
 * time   : 2022/7/1
 * desc   : ViewModel 层：编写 MainViewModel，并通过 LiveData 绑定 Model 层和 ViewModel 层
 */
class Case07ViewModel : ViewModel() {

    private val articleRepository = ArticleRepository()

    val articlesLiveData = MutableLiveData<String>()

    fun getArticle() {
        viewModelScope.launch {
            articlesLiveData.value = articleRepository.getArticle()
        }
    }
}
