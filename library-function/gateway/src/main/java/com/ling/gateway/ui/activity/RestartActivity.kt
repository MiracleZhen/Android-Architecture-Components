package com.ling.gateway.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.ling.common.app.AppActivity
import com.ling.gateway.R
import com.ling.utils.AppUtils
import com.ling.utils.IntentUtils

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/6
 * desc   : 重启应用
 */
class RestartActivity : AppActivity() {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, RestartActivity::class.java)
            if (context !is Activity) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }

        fun restart(context: Context) {
            /*val intent: Intent = if (true) {
                // 如果是未登录的情况下跳转到闪屏页
                Intent(context, SplashActivity::class.java)
            } else {
                // 如果是已登录的情况下跳转到首页
                Intent(context, HomeActivity::class.java)
            }*/
            val intent = IntentUtils.getLaunchAppIntent(AppUtils.getAppPackageName())
            if (context !is Activity) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }
    }

    override fun getLayoutId(): Int {
        return 0
    }

    override fun initView() {}

    override fun initData() {
        restart(this)
        finish()
        toast(R.string.common_crash_hint)
    }
}
