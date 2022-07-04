package com.ling.coroutine.type01.p1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P01Case07Binding

/**
 * author : wangchengzhen
 * time   : 2022/7/1
 * desc   : Kotlin 协程 （七） ——— 协程 + Retrofit 实战
 * blog   : https://juejin.cn/post/7087587988552564766
 */
class Case07Activity : AppCompatActivity() {

    /**
     * 一、效果图
     * 二、准备工作
     * 三、View 层：编写布局
     * 四、Model 层：编写 Retrofit API
     * 五、Model 层：编写仓库类，获取数据
     * 六、ViewModel 层：编写 MainViewModel，并通过 LiveData 绑定 Model 层和 ViewModel 层
     * 七、通过 DataBinding 绑定 View 和 ViewModel
     * 八、View 层：MainActivity 中使用 DataBinding
     */

    private val case07ViewModel: Case07ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityType01P01Case07Binding>(this, R.layout.activity_type01_p01_case07)
        binding.lifecycleOwner = this
        binding.case07ViewModel = case07ViewModel
    }
}
