package com.ling.dagger2.hilt

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ling.dagger2.hilt.impl.AnalyticsService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : HiltActivity
 */
@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {

    @Named("appName")
    @Inject
    lateinit var appName: String

    @Named("activityName")
    @Inject
    lateinit var activityName: String

    @Inject
    lateinit var analyticsService: AnalyticsService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, "$appName, $activityName, ${analyticsService.hashCode()}", Toast.LENGTH_SHORT).show()
    }
}
