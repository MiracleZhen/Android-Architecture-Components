package com.ling.dagger2.part05.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ling.dagger2.databinding.FragmentDemoBinding
import com.ling.dagger2.part05.activity.ActivityData
import com.ling.dagger2.part05.app.AppData
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import javax.inject.Named

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : DemoFragment
 */
class DemoFragment : Fragment() {

    @Inject
    lateinit var appData: AppData

    @Inject
    lateinit var activityData: ActivityData

    @Named("fragmentData")
    @Inject
    lateinit var fragmentData: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentDemoBinding.inflate(inflater, container, false)
        binding.tvData.text = "appData = ${appData.hashCode()}" +
                "\nactivityData = ${activityData.hashCode()}" +
                "\nfragmentData = $fragmentData"
        return binding.root
    }
}
