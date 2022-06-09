package com.ling.mvc.ui.activity

import android.view.KeyEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ling.aop.annotation.SingleClick
import com.ling.common.app.AppActivity
import com.ling.common.manager.InputTextManager
import com.ling.http.EasyHttp
import com.ling.http.listener.HttpCallback
import com.ling.http.listener.OnHttpListener
import com.ling.mvc.R
import com.ling.mvc.http.api.GetCodeApi
import com.ling.mvc.http.api.VerifyCodeApi
import com.ling.mvc.http.model.HttpData
import com.ling.widget.view.text.CountdownView
import okhttp3.Call
import java.lang.Exception

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/9
 * desc   : 忘记密码
 */
class PasswordForgetActivity : AppActivity(), TextView.OnEditorActionListener {

    private val phoneView: EditText? by lazy { findViewById(R.id.et_password_forget_phone) }
    private val codeView: EditText? by lazy { findViewById(R.id.et_password_forget_code) }
    private val countdownView: CountdownView? by lazy { findViewById(R.id.cv_password_forget_countdown) }
    private val commitView: Button? by lazy { findViewById(R.id.btn_password_forget_commit) }

    override fun getLayoutId(): Int {
        return R.layout.password_forget_activity
    }

    override fun initView() {
        setOnClickListener(countdownView, commitView)
        codeView?.setOnEditorActionListener(this)
        commitView?.let {
            InputTextManager.with(this)
                .addView(phoneView)
                .addView(codeView)
                .setMain(it)
                .build()
        }
    }

    override fun initData() {
    }

    @SingleClick
    override fun onClick(view: View) {
        if (view === countdownView) {
            if (phoneView?.text.toString().length != 11) {
                phoneView?.startAnimation(
                    AnimationUtils.loadAnimation(
                        getContext(),
                        R.anim.shake_anim
                    )
                )
                toast(R.string.common_phone_input_error)
                return
            }
            if (true) {
                toast(R.string.common_code_send_hint)
                countdownView?.start()
                return
            }

            // 隐藏软键盘
            hideKeyboard(currentFocus)

            // 获取验证码
            EasyHttp.post(this)
                .api(GetCodeApi().apply {
                    setPhone(phoneView?.text.toString())
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
                        toast(R.string.common_code_send_hint)
                        countdownView?.start()
                    }
                })

        } else if (view === commitView) {

            if (phoneView?.text.toString().length != 11) {
                phoneView?.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shake_anim))
                toast(R.string.common_phone_input_error)
                return
            }

            if (codeView?.text.toString().length != resources.getInteger(R.integer.sms_code_length)) {
                codeView?.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shake_anim))
                toast(R.string.common_code_error_hint)
                return
            }
            if (true) {
                PasswordResetActivity.start(this, phoneView?.text.toString(), codeView?.text.toString())
                finish()
                return
            }

            // 验证码校验
            EasyHttp.post(this)
                .api(VerifyCodeApi().apply {
                    setPhone(phoneView?.text.toString())
                    setCode(codeView?.text.toString())
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
                        PasswordResetActivity.start(this@PasswordForgetActivity,
                            phoneView?.text.toString(), codeView?.text.toString())
                        finish()
                    }
                })
        }
    }

    /**
     * [TextView.OnEditorActionListener]
     */
    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            // 模拟点击下一步按钮
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
