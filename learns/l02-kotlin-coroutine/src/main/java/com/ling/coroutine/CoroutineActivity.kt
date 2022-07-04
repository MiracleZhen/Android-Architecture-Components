package com.ling.coroutine

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.databinding.ActivityCoroutineBinding
import com.ling.coroutine.type01.Type01Activity

/**
 * author : wangchengzhen
 * time   : 2022/6/30
 * desc   : Kotlin coroutine
 */
class CoroutineActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnType1.setOnClickListener(this)
        binding.btnType2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_type1 -> {
                startActivity(Intent(this, Type01Activity::class.java))
            }
            R.id.btn_type2 -> {
            }
        }
    }
}
