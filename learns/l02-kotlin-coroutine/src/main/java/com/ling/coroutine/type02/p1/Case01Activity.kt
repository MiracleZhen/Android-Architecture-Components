package com.ling.coroutine.type02.p1

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityCase01Binding
import kotlinx.coroutines.*

/**
 * author : wangchengzhen
 * time   : 2022/6/12
 * desc   : 协程与异步任务对比
 */
class Case01Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCase01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCase01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAsyncTask.setOnClickListener(this)
        binding.btnUseCoroutine.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_async_task -> {
                asyncTask()
            }
            R.id.btn_use_coroutine -> {
                useCoroutine()
            }
        }
    }

    /**
     * 异步任务
     */
    @SuppressLint("StaticFieldLeak")
    private fun asyncTask() {
        object : AsyncTask<Void, Void, String?>() {
            override fun doInBackground(vararg params: Void?): String? {
                val requestParams = HashMap<String, String>().apply {
                    this["username"] = "miracle"
                    this["password"] = "123456"
                }
                // return ApiService.getApiService().login(requestParams).execute().body()
                return null
            }

            override fun onPostExecute(result: String?) {
                binding.tvResult.text = result
            }
        }.execute()
    }

    /**
     * 使用协程
     */
    @DelicateCoroutinesApi
    private fun useCoroutine() {
        GlobalScope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                val requestParams = HashMap<String, String>().apply {
                    this["username"] = "miracle"
                    this["password"] = "123456"
                }
                // ApiService.getApiService().loginCoroutine(requestParams)
                null
            }

            binding.tvResult.text = result
        }
    }
}
