package com.ling.mvc.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.util.Log
import android.view.View
import com.airbnb.lottie.LottieAnimationView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar
import com.ling.common.app.AppActivity
import com.ling.http.EasyHttp
import com.ling.http.listener.HttpCallback
import com.ling.http.listener.OnHttpListener
import com.ling.mvc.R
import com.ling.mvc.config.AppConfig
import com.ling.mvc.http.api.UserInfoApi
import com.ling.mvc.http.model.HttpData
import com.ling.widget.view.text.SlantedTextView
import okhttp3.Call
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/5/19
 * desc   : 闪屏界面
 */
class SplashActivity : AppActivity() {

    private val lottieView: LottieAnimationView? by lazy { findViewById(R.id.lav_splash_lottie) }
    private val debugView: SlantedTextView? by lazy { findViewById(R.id.iv_splash_debug) }

    override fun getLayoutId(): Int {
        return R.layout.splash_activity
    }

    override fun initView() {
        // 设置动画监听
        lottieView?.addAnimatorListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                lottieView?.removeAnimatorListener(this)
                HomeActivity.start(this@SplashActivity)
                finish()
            }
        })
    }

    override fun initData() {
        debugView?.let {
            it.setText(AppConfig.getBuildType().uppercase(Locale.getDefault()))
            it.visibility = if (AppConfig.isDebug()) View.VISIBLE else View.INVISIBLE
        }

        if (true) {
            return
        }
        // 刷新用户信息
        EasyHttp.post(this)
            .api(UserInfoApi())
            .request(object : HttpCallback<HttpData<UserInfoApi.Bean?>>(object : OnHttpListener<Any> {

                override fun onStart(call: Call?) {
                    showDialog()
                }

                override fun onSucceed(result: Any?) {
                    if (result is HttpData<*>) {
                        toast(result.getMessage())
                    }
                }

                override fun onFail(e: Exception?) {
                    e?.let { toast(it.message) }
                }

                override fun onEnd(call: Call?) {
                    hideDialog()
                }
            }) {
                override fun onSucceed(data: HttpData<UserInfoApi.Bean?>) {

                }
            })
    }

    override fun createStatusBarConfig(): ImmersionBar {
        return super.createStatusBarConfig()
            // 隐藏状态栏和导航栏
            .hideBar(BarHide.FLAG_HIDE_BAR)
    }

    override fun onBackPressed() {
        // 禁用返回键
        //super.onBackPressed();
    }

    override fun initActivity() {
        // 问题及方案：https://www.cnblogs.com/net168/p/5722752.html
        // 如果当前 Activity 不是任务栈中的第一个 Activity
        if (!isTaskRoot) {
            val intent: Intent? = intent
            // 如果当前 Activity 是通过桌面图标启动进入的
            if (((intent != null) && intent.hasCategory(Intent.CATEGORY_LAUNCHER)
                        && (Intent.ACTION_MAIN == intent.action))) {
                // 对当前 Activity 执行销毁操作，避免重复实例化入口
                finish()
                return
            }
        }
        super.initActivity()
    }

    override fun onDestroy() {
        // 因为修复了一个启动页被重复启动的问题，所以有可能 Activity 还没有初始化完成就已经销毁了
        // 所以如果需要在此处释放对象资源需要先对这个对象进行判空，否则可能会导致空指针异常
        super.onDestroy()
    }
}
