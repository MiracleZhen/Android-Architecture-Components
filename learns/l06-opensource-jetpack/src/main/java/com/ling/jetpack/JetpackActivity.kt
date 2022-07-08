package com.ling.jetpack

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.jetpack.databinding.ActivityJetpackBinding
import com.ling.jetpack.p1_lifecycle.LifecycleActivity

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : Jetpack
 */
class JetpackActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityJetpackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest1.setOnClickListener(this)
        binding.btnTest2.setOnClickListener(this)
        binding.btnTest3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> startActivity(Intent(this, LifecycleActivity::class.java))
        }
    }
}
