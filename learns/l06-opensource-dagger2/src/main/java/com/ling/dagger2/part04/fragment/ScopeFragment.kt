package com.ling.dagger2.part04.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ling.dagger2.databinding.FragmentScopeBinding
import com.ling.dagger2.part04.activity.ScopeActivity
import com.ling.dagger2.part04.activity.ScopeActivityNormalData
import com.ling.dagger2.part04.activity.ScopeActivitySharedData
import com.ling.dagger2.part04.app.ScopeAppData
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : ScopeFragment
 */
class ScopeFragment : Fragment() {

    private var scopeActivity: ScopeActivity? = null

    @Inject
    lateinit var scopeAppData: ScopeAppData

    @Inject
    lateinit var scopeActivitySharedData: ScopeActivitySharedData

    @Inject
    lateinit var scopeActivityNormalData: ScopeActivityNormalData

    @Inject
    lateinit var scopeFragmentData: ScopeFragmentData

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.scopeActivity = context as ScopeActivity
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentScopeBinding.inflate(inflater, container, false)
        scopeActivity?.getScopeActivityComponent()?.scopeFragmentComponent()?.inject(this)
        binding.tvScope.text = "[ScopeFragment Space] \n scopeAppData = $scopeAppData" +
                "\n\n scopeActivitySharedData = $scopeActivitySharedData" +
                "\n\n scopeActivityNormalData = $scopeActivityNormalData" +
                "\n\n scopeFragmentData = $scopeFragmentData"
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
