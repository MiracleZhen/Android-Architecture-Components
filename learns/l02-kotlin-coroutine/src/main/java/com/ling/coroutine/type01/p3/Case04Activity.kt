package com.ling.coroutine.type01.p3

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P03Case04Binding
import com.ling.coroutine.download.DownloadManager
import com.ling.coroutine.download.DownloadState
import kotlinx.coroutines.flow.collect
import java.io.File

/**
 * author : wangchengzhen
 * time   : 2022/7/4
 * desc   : Kotlin 协程 （十五） ——— Flow + Retrofit 下载文件
 * blog   : https://juejin.cn/post/7090570934125330468
 */
class Case04Activity : AppCompatActivity() {

    /**
     * 一、声明 ApiService 接口
     * 二、定义 DownloadState
     * 三、定义 DownloadManager
     * 四、使用 DownloadManager
     */

    private lateinit var binding: ActivityType01P03Case04Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityType01P03Case04Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest1.setOnClickListener {
            download()
        }
    }

    /**
     * 在 Activity 中使用 DownloadManager
     */
    private fun download() {
        lifecycleScope.launchWhenCreated {
            DownloadManager.download(
                "https://upload-images.jianshu.io/upload_images/5809200-a99419bb94924e6d.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240",
                File(getExternalFilesDir(""), "image.png")
            ).collect {
                when (it) {
                    is DownloadState.InProgress -> {
                        Log.d("~~~", "download in progress: ${it.progress}.")
                        binding.progress.progress = it.progress
                    }
                    is DownloadState.Success -> {
                        Log.d("~~~", "download finished, file: ${it.file}.")
                        BitmapFactory.decodeFile(it.file.absolutePath)?.let { bitmap ->
                            binding.iv.setImageBitmap(bitmap)
                        }
                    }
                    is DownloadState.Error -> {
                        Log.d("~~~", "download error: ${it.throwable}.")
                    }
                }
            }
        }
    }
}
