package com.ling.coroutine.type01.p3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P03Case01Binding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * author : wangchengzhen
 * time   : 2022/7/4
 * desc   : Kotlin 协程 （十二） ——— Channel 简介
 * blog   : https://juejin.cn/post/7089452562445369375
 */
class Case01Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、send() 发送数据，receive() 接收数据
     * 二、迭代器 Iterator
     * 三、Channel 缓冲区
     * 四、produce() 创建生产者协程
     * 五、actor() 创建消费者协程
     * 六、关闭 Channel
     * 七、BroadcastChannel
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P03Case01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest1.setOnClickListener(this)
        binding.btnTest2.setOnClickListener(this)
        binding.btnTest3.setOnClickListener(this)
        binding.btnTest4.setOnClickListener(this)
        binding.btnTest5.setOnClickListener(this)
        binding.btnTest6.setOnClickListener(this)
        binding.btnTest7.setOnClickListener(this)
        binding.btnTest8.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> test01()
            R.id.btn_test2 -> test02()
            R.id.btn_test3 -> test03()
            R.id.btn_test4 -> test04()
            R.id.btn_test5 -> test05()
            R.id.btn_test6 -> test06()
            R.id.btn_test7 -> test07()
            R.id.btn_test8 -> test08()
        }
    }

    /**
     * send() 发送数据，receive() 接收数据
     */
    private fun test01() = runBlocking {
        val channel = Channel<Int>()
        launch {
            repeat(3) {
                println("send: $it")
                channel.send(it)
            }
        }
        launch {
            repeat(3) {
                val result = channel.receive()
                println("receive: $result")
            }
        }
    }

    /**
     * 迭代器 Iterator
     */
    private fun test02() = runBlocking {
        val channel = Channel<Int>()
        launch {
            repeat(3) {
                println("send: $it")
                channel.send(it)
            }
            channel.close()
        }
        launch {
            val iterator = channel.iterator()
            while (iterator.hasNext()) {
                val result = iterator.next()
                println("receive: $result")
            }
        }
    }

    /**
     * 通过 for-in 循环获取 Channel 中的所有元素
     */
    private fun test03() = runBlocking {
        val channel = Channel<Int>()
        launch {
            repeat(3) {
                println("send: $it")
                channel.send(it)
            }
            channel.close()
        }
        launch {
            for (element in channel) {
                println("element: $element")
            }
        }
    }

    /**
     * Channel 缓冲区
     */
    private fun test04() = runBlocking {
        val startTime = System.currentTimeMillis()
        val channel = Channel<Int>(2)
        launch {
            repeat(3) {
                println("send: $it, time: ${System.currentTimeMillis() - startTime}")
                channel.send(it)
            }
        }
        launch {
            repeat(3) {
                delay(1000)
                val result = channel.receive()
                println("receive: $result, time: ${System.currentTimeMillis() - startTime}")
            }
        }
    }

    /**
     * produce() 创建生产者协程
     */
    private fun test05() = runBlocking {
        val receiveChannel = produce {
            repeat(3) {
                send(it)
            }
        }
        launch {
            for (element in receiveChannel) {
                println("$element")
            }
        }
    }

    /**
     * actor() 创建消费者协程
     */
    private fun test06() = runBlocking {
        val sendChannel = actor<Int> {
            repeat(3) {
                val result = receive()
                println("$result")
            }
        }
        launch {
            repeat(3) {
                sendChannel.send(it)
            }
        }
    }

    /**
     * 关闭 Channel
     */
    private fun test07() = runBlocking {
        val channel = Channel<Int>(3)
        launch {
            repeat(3) {
                channel.send(it)
            }
            channel.close()
            println("Channel closed, isClosedForSend = ${channel.isClosedForSend}, isClosedForReceive = ${channel.isClosedForReceive}")
        }
        launch {
            delay(1000)
            repeat(3) {
                channel.receive()
            }
            println("All received, isClosedForSend = ${channel.isClosedForSend}, isClosedForReceive = ${channel.isClosedForReceive}")
        }
    }

    /**
     * BroadcastChannel
     */
    private fun test08() = runBlocking {
        val broadcastChannel = BroadcastChannel<Int>(Channel.BUFFERED)
        repeat(3) {
            GlobalScope.launch {
                val receiveChannel = broadcastChannel.openSubscription()
                for (element in receiveChannel) {
                    println("coroutine $it received element: $element")
                }
            }
        }
        GlobalScope.launch {
            repeat(3) {
                broadcastChannel.send(it)
            }
            broadcastChannel.close()
        }
    }
}
