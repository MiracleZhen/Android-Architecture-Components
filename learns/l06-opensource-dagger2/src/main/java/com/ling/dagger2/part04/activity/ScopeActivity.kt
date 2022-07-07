package com.ling.dagger2.part04.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ling.dagger2.databinding.ActivityScopeBinding
import com.ling.dagger2.part04.app.ScopeApp
import com.ling.dagger2.part04.app.ScopeAppData
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : ScopeActivity
 */
class ScopeActivity : AppCompatActivity() {

    private var scopeActivityComponent: ScopeActivityComponent? = null

    @Inject
    lateinit var scopeAppData: ScopeAppData

    @Inject
    lateinit var scopeActivitySharedData1: ScopeActivitySharedData

    @Inject
    lateinit var scopeActivitySharedData2: ScopeActivitySharedData

    @Inject
    lateinit var scopeActivityNormalData1: ScopeActivityNormalData

    @Inject
    lateinit var scopeActivityNormalData2: ScopeActivityNormalData

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityScopeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getScopeActivityComponent().inject(this)
        binding.tvScope.text = "[ScopeActivity Space] \n scopeAppData = $scopeAppData" +
                "\n\nscopeActivitySharedData1 = $scopeActivitySharedData1" +
                "\n\nscopeActivitySharedData2 = $scopeActivitySharedData2" +
                "\n\nscopeActivityNormalData1 = $scopeActivityNormalData1" +
                "\n\nscopeActivityNormalData2 = $scopeActivityNormalData2"
    }

    fun getScopeActivityComponent(): ScopeActivityComponent {
        if (scopeActivityComponent == null) {
            val scopeAppComponent = (application as ScopeApp).getAppComponent()
            scopeActivityComponent = DaggerScopeActivityComponent.builder()
                .scopeAppComponent(scopeAppComponent)
                .build()
        }
        return scopeActivityComponent!!
    }
}
