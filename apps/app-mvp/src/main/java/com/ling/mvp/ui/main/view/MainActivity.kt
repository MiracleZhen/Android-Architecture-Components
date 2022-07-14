package com.ling.mvp.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.ling.mvp.R
import com.ling.mvp.databinding.ActivityMainBinding
import com.ling.mvp.ui.about.view.AboutFragment
import com.ling.mvp.ui.base.view.BaseActivity
import com.ling.mvp.ui.feed.view.FeedActivity
import com.ling.mvp.ui.login.view.LoginActivity
import com.ling.mvp.ui.main.interactor.MainMvpInteractor
import com.ling.mvp.ui.main.interactor.QuestionCardData
import com.ling.mvp.ui.main.presenter.MainMvpPresenter
import com.ling.mvp.ui.rate.view.RateUsDialog
import com.ling.mvp.utils.ScreenUtils
import com.ling.mvp.utils.extension.addFragment
import com.ling.mvp.utils.extension.removeFragment
import com.mindorks.placeholderview.SwipeDecor
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : MainActivity
 */
class MainActivity : BaseActivity<ActivityMainBinding>(), MainMvpView, HasAndroidInjector {

    @Inject
    internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    internal lateinit var presenter: MainMvpPresenter<MainMvpView, MainMvpInteractor>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun initView() {
        setUpDrawerMenu()
        setupCardContainerView()
    }

    override fun initData() {

    }

    private fun setUpDrawerMenu() {
        setSupportActionBar(binding?.includedNav?.toolbar)
        val toggle = ActionBarDrawerToggle(this, binding?.drawerLayout, binding?.includedNav?.toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binding?.drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()
        binding?.navView?.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navItemAbout -> presenter.onDrawerOptionAboutClick()
                R.id.navItemRateUs -> presenter.onDrawerOptionRateUsClick()
                R.id.navItemFeed -> presenter.onDrawerOptionFeedClick()
                R.id.navItemLogout -> presenter.onDrawerOptionLogoutClick()
            }
            binding?.drawerLayout?.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun setupCardContainerView() {
        val screenWidth = ScreenUtils.getScreenWidth(this)
        val screenHeight = ScreenUtils.getScreenHeight(this)
        binding?.questionHolder?.builder?.apply {
            setDisplayViewCount(3)
            setHeightSwipeDistFactor(10f)
            setWidthSwipeDistFactor(5f)
            setSwipeDecor(SwipeDecor()
                .setViewWidth((0.90 * screenWidth).toInt())
                .setViewHeight((0.75 * screenHeight).toInt())
                .setPaddingTop(20)
                .setSwipeRotationAngle(10)
                .setRelativeScale(0.01f))
        }
        binding?.questionHolder?.addItemRemoveListener { count ->
            if (count == 0) {
                postDelayed({ presenter.refreshQuestionCards() }, 500)
            }
        }
    }

    override fun onBackPressed() {
        binding?.drawerLayout?.isDrawerOpen(GravityCompat.START)?.let {
            if (it) {
                binding?.drawerLayout?.closeDrawer(GravityCompat.START)
            }
        }
        val fragment = supportFragmentManager.findFragmentByTag(AboutFragment.TAG)
        fragment?.let { onFragmentDetached(AboutFragment.TAG) } ?: super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
        supportFragmentManager.removeFragment(tag = tag)
        unlockDrawer()
    }

    override fun inflateUserDetails(userDetails: Pair<String?, String?>) {
        binding?.navView?.getHeaderView(0)?.let {
            if (it is ViewGroup) {
                it.findViewById<TextView>(R.id.nav_name).text = userDetails.first
                it.findViewById<TextView>(R.id.nav_email).text = userDetails.second
            }
        }
    }

    override fun displayQuestionCard(questionCardList: List<QuestionCardData>) {
        questionCardList.forEach {
            binding?.questionHolder?.addView(QuestionCardView(it))
        }
    }

    override fun openLoginActivity() {
        startActivity(LoginActivity::class.java)
        finish()
    }

    override fun openFeedActivity() {
        startActivity(FeedActivity::class.java)
    }

    override fun openAboutFragment() {
        lockDrawer()
        supportFragmentManager.addFragment(R.id.cl_root_view, AboutFragment.newInstance(), AboutFragment.TAG)
    }

    override fun openRateUsDialog(): Unit = RateUsDialog.newInstance().show(supportFragmentManager)

    override fun lockDrawer(): Unit? {
        return binding?.drawerLayout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    override fun unlockDrawer(): Unit? {
        return binding?.drawerLayout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }
}
