package com.ling.coroutine.type01.p3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P03Case02Binding
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

/**
 * author : wangchengzhen
 * time   : 2022/7/4
 * desc   : Kotlin 协程 （十三） ——— 多路复用
 * blog   : https://juejin.cn/post/7089808716135923742
 */
class Case02Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、多路复用
     * 二、await() 多路复用
     * 三、Channel 多路复用
     * 四、判断函数是否可以被 select()：SelectClause
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P03Case02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest1.setOnClickListener(this)
        binding.btnTest2.setOnClickListener(this)
        binding.btnTest3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> test01()
            R.id.btn_test2 -> test02()
            R.id.btn_test3 -> test03()
        }
    }

    /**
     * await() 多路复用
     */
    private fun test01() = runBlocking {
        val deferred1 = async {
            delay(1000)
            "response1"
        }
        val deferred2 = async {
            delay(2000)
            "response2"
        }
        val result = select<String> {
            deferred1.onAwait { it }
            deferred2.onAwait { it }
        }
        println("result: $result")
    }

    /**
     * Channel 多路复用
     */
    private fun test02() = runBlocking {
        val channel1 = Channel<Int>()
        val channel2 = Channel<Int>()
        launch {
            delay(1000)
            if (!channel1.isClosedForSend) {
                channel1.send(1)
            }
        }
        launch {
            delay(2000)
            if (!channel2.isClosedForSend) {
                channel2.send(2)
            }
        }
        val result = select<Int> {
            channel1.onReceive { it }
            channel2.onReceive { it }
        }
        println("result: $result")
        channel1.close()
        channel2.close()
    }

    /**
     * 判断函数是否可以被 select()：SelectClause
     */
    private fun test03() = runBlocking {
        val job1 = launch {
            delay(1000)
            println("job1 done")
        }
        val job2 = launch {
            delay(2000)
            println("job2 done")
        }
        select<Unit> {
            job1.onJoin {
                println("select job1")
            }
            job2.onJoin {
                println("select job2")
            }
        }
    }
}
