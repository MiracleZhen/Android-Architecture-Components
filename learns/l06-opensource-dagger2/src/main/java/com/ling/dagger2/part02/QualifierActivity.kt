package com.ling.dagger2.part02

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ling.dagger2.databinding.ActivityQualifierBinding

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : Dagger2 知识梳理(2) @Qulifier 和 @Named 解决依赖注入迷失
 * blog   : https://juejin.cn/post/6844903524061413384
 */
class QualifierActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQualifierBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetLocalData.setOnClickListener {
            val repository = DataRepository()
            val data = repository.getLocalData()
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        }
        binding.btnGetNetData.setOnClickListener {
            val repository = DataRepository()
            val data = repository.getRemoteData()
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        }
    }
}
