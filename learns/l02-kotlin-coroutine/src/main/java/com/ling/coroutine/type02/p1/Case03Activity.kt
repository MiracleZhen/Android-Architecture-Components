package com.ling.coroutine.type02.p1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.databinding.ActivityCase03Binding
import kotlinx.coroutines.*

/**
 * author : wangchengzhen
 * time   : 2022/6/12
 * desc   : CoroutineScope - MainScope
 */
class Case03Activity : AppCompatActivity(), CoroutineScope by MainScope() {

    private lateinit var binding: ActivityCase03Binding
    // private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCase03Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainScope.setOnClickListener {
            testMainScope()
        }
    }

    private fun testMainScope() {
        /*mainScope.launch {
            val requestParams = HashMap<String, String>().apply {
                this["username"] = "miracle"
                this["password"] = "123456"
            }
            val result = ApiService.getApiService().loginCoroutine(requestParams)
            binding.tvResult.text = result

            delay(5000)
        }*/

        launch {
            val requestParams = HashMap<String, String>().apply {
                this["username"] = "miracle"
                this["password"] = "123456"
            }
            // val result = ApiService.getApiService().loginCoroutine(requestParams)
            binding.tvResult.text = null

            delay(5000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // mainScope.cancel()

        cancel()
    }
}
