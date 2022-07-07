package com.ling.dagger2.part05.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : BaseActivity
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 一处声明，处处依赖注入
        AndroidInjection.inject(this)
    }
}
