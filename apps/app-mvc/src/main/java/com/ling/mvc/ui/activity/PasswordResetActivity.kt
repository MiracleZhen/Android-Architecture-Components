package com.ling.mvc.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.KeyEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ling.aop.annotation.Log
import com.ling.aop.annotation.SingleClick
import com.ling.base.BaseDialog
import com.ling.common.app.AppActivity
import com.ling.common.manager.InputTextManager
import com.ling.http.EasyHttp
import com.ling.http.listener.HttpCallback
import com.ling.http.listener.OnHttpListener
import com.ling.mvc.R
import com.ling.mvc.http.api.PasswordApi
import com.ling.mvc.http.model.HttpData
import com.ling.widget.dialog.TipsDialog
import okhttp3.Call
import java.lang.Exception

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/9
 * desc   : 重置密码
 */
class PasswordResetActivity : AppActivity(), TextView.OnEditorActionListener {

    companion object {

        private const val INTENT_KEY_IN_PHONE: String = "phone"
        private const val INTENT_KEY_IN_CODE: String = "code"

        @Log
        fun start(context: Context, phone: String?, code: String?) {
            val intent = Intent(context, PasswordResetActivity::class.java)
            intent.putExtra(INTENT_KEY_IN_PHONE, phone)
            intent.putExtra(INTENT_KEY_IN_CODE, code)
            if (context !is Activity) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }
    }

    private val firstPassword: EditText? by lazy { findViewById(R.id.et_password_reset_password1) }
    private val secondPassword: EditText? by lazy { findViewById(R.id.et_password_reset_password2) }
    private val commitView: Button? by lazy { findViewById(R.id.btn_password_reset_commit) }

    /** 手机号 */
    private var phoneNumber: String? = null

    /** 验证码 */
    private var verifyCode: String? = null

    override fun getLayoutId(): Int {
        return R.layout.password_reset_activity
    }

    override fun initView() {
        setOnClickListener(commitView)
        secondPassword?.setOnEditorActionListener(this)
        commitView?.let {
            InputTextManager.with(this)
                .addView(firstPassword)
                .addView(secondPassword)
                .setMain(it)
                .build()
        }
    }

    override fun initData() {
        phoneNumber = getString(INTENT_KEY_IN_PHONE)
        verifyCode = getString(INTENT_KEY_IN_CODE)
    }

    @SingleClick
    override fun onClick(view: View) {
        if (view === commitView) {
            if (firstPassword?.text.toString() != secondPassword?.text.toString()) {
                firstPassword?.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shake_anim))
                secondPassword?.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shake_anim))
                toast(R.string.common_password_input_unlike)
                return
            }

            // 隐藏软键盘
            hideKeyboard(currentFocus)
            if (true) {
                TipsDialog.Builder(this)
                    .setIcon(TipsDialog.ICON_FINISH)
                    .setMessage(R.string.password_reset_success)
                    .setDuration(2000)
                    .addOnDismissListener(object : BaseDialog.OnDismissListener {

                        override fun onDismiss(dialog: BaseDialog?) {
                            finish()
                        }
                    })
                    .show()
                return
            }

            // 重置密码
            EasyHttp.post(this)
                .api(PasswordApi().apply {
                    setPhone(phoneNumber)
                    setCode(verifyCode)
                    setPassword(firstPassword?.text.toString())
                })
                .request(object : HttpCallback<HttpData<Void?>>(object : OnHttpListener<Any> {

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

                    override fun onSucceed(data: HttpData<Void?>) {
                        TipsDialog.Builder(this@PasswordResetActivity)
                            .setIcon(TipsDialog.ICON_FINISH)
                            .setMessage(R.string.password_reset_success)
                            .setDuration(2000)
                            .addOnDismissListener(object : BaseDialog.OnDismissListener {

                                override fun onDismiss(dialog: BaseDialog?) {
                                    finish()
                                }
                            })
                            .show()
                    }
                })
        }
    }

    /**
     * [TextView.OnEditorActionListener]
     */
    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            // 模拟点击提交按钮
            commitView?.let {
                if (it.isEnabled) {
                    onClick(it)
                    return true
                }
            }
        }
        return false
    }
}
