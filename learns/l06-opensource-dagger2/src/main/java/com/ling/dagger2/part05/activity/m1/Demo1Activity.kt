package com.ling.dagger2.part05.activity.m1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ling.dagger2.R
import com.ling.dagger2.databinding.ActivityDemo1Binding
import com.ling.dagger2.part05.activity.ActivityData
import com.ling.dagger2.part05.activity.BaseActivity
import com.ling.dagger2.part05.app.AppData
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : Demo1Activity
 */
class Demo1Activity : BaseActivity() {

    @Inject
    lateinit var appData: AppData

    @Inject
    lateinit var activityData: ActivityData

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDemo1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvData.text = "appData = ${appData.hashCode()}, \nactivityData: ${activityData.hashCode()}"
    }
}
