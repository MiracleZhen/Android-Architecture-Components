package com.ling.dagger2.part05.activity.m2

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.ling.dagger2.part05.activity.BaseActivity
import javax.inject.Inject
import javax.inject.Named

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : DemoActivity
 */
class Demo2Activity : BaseActivity() {

    @Named("name")
    @Inject
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }
}
