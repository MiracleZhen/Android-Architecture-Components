package com.ling.dagger2.part01

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ling.dagger2.databinding.ActivityRepositoryBinding

/**
 * author : wangchengzhen
 * time   : 2022/7/5
 * desc   : Dagger2 知识梳理(1) Dagger2 依赖注入的两种方式
 * blog   : https://juejin.cn/post/6844903524032053261
 */
class RepositoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetLocalData.setOnClickListener {
            val repository = DataRepository()
            val data = repository.getData()
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        }

        binding.btnGetRemoteData.setOnClickListener {
            val repository = DataRepository()
            val data = repository.getNetData()
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        }
    }
}
