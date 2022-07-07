package com.ling.dagger2.part03

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ling.dagger2.R
import com.ling.dagger2.databinding.ActivityComponentBinding

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : Dagger2 知识梳理(3) 使用 dependencies 和 @SubComponent 完成依赖注入
 * blog   : https://juejin.cn/post/6844903524061429767
 */
class ComponentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetLocalData.setOnClickListener {
            val repository = DataRepository()
            val data = repository.getDependencyData()
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        }
        binding.btnGetNetData.setOnClickListener {
            val repository = SubRepository()
            val data = repository.getLocalData()
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        }
    }
}
