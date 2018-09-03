package com.lee.android.music

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout.Tab
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.qmuiteam.qmui.widget.QMUIPagerAdapter
import com.qmuiteam.qmui.widget.QMUITopBarLayout
import kotlinx.android.synthetic.main.activity_main.drawerLayout
import kotlinx.android.synthetic.main.activity_main.navigation
import kotlinx.android.synthetic.main.activity_main.tabs
import kotlinx.android.synthetic.main.activity_main.viewPager
import timber.log.Timber

class MainActivity : AppCompatActivity() {
  lateinit var topBarLayout: QMUITopBarLayout
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    QMUIStatusBarHelper.setStatusBarLightMode(this)
    QMUIStatusBarHelper.translucent(this) // 沉浸式状态栏
    setContentView(R.layout.activity_main).apply {
      topBarLayout = findViewById(R.id.topBar)
      topBarLayout.addLeftImageButton(R.drawable.ic_menu_white_24dp, R.id.topbar_left_menu_button)
          .setOnClickListener {
            drawerLayout.openDrawer(Gravity.START)
          }
      val normalColor =
        ContextCompat.getColor(this@MainActivity, R.color.text_primary)
      val selectColor =
        ContextCompat.getColor(this@MainActivity, R.color.app_color_blue)
      tabs.setDefaultNormalColor(normalColor)
      tabs.setDefaultSelectedColor(selectColor)
      tabs.setHasIndicator(true)
      viewPager.adapter = mPagerAdapter
      tabs.setupWithViewPager(viewPager)
      navigation.setNavigationItemSelectedListener { item ->
        when (item.itemId) {
          R.id.playlist -> {
//            Timber.e("playlist")
          }
          R.id.equalizer -> {
          }
          R.id.about -> {
          }
          R.id.setting -> {
          }
        }
        true
      }
    }
  }

  private val mPagerAdapter = object : QMUIPagerAdapter() {
    private var mCurrentTransaction: FragmentTransaction? = null
    private var mCurrentPrimaryItem: Fragment? = null

    override fun hydrate(
      container: ViewGroup,
      position: Int
    ): Any = when (position) {
      0 -> MainFragment()
      else -> EmptyFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {

      return when (position) {
        0 -> "发现"
        1 -> "排行榜"
        2 -> "MV"
        3 -> "我的"
        else -> "其他"
      }
    }

    @SuppressLint("CommitTransaction")
    override fun populate(
      container: ViewGroup,
      item: Any,
      position: Int
    ) {
      val name = makeFragmentName(container.id, position.toLong())
      if (mCurrentTransaction == null) {
        mCurrentTransaction = supportFragmentManager.beginTransaction()
      }
      var fragment = supportFragmentManager.findFragmentByTag(name)
      if (fragment != null) {
        mCurrentTransaction!!.attach(fragment)
      } else {
        fragment = item as Fragment
        mCurrentTransaction!!.add(container.id, fragment, name)
      }
      if (fragment !== mCurrentPrimaryItem) {
        fragment.setMenuVisibility(false)
        fragment.userVisibleHint = false
      }
    }

    @SuppressLint("CommitTransaction")
    override fun destroy(
      container: ViewGroup,
      position: Int,
      `object`: Any
    ) {
      if (mCurrentTransaction == null) {
        mCurrentTransaction = supportFragmentManager.beginTransaction()
      }
      mCurrentTransaction!!.detach(`object` as Fragment)
    }

    override fun startUpdate(container: ViewGroup) {
      if (container.id == View.NO_ID) {
        throw IllegalStateException("ViewPager with adapter " + this + " requires a view id")
      }
    }

    override fun getCount(): Int {
      return 4
    }

    override fun isViewFromObject(
      view: View,
      `object`: Any
    ): Boolean {
      return view === (`object` as Fragment).view
    }

    override fun finishUpdate(container: ViewGroup) {
      if (mCurrentTransaction != null) {
        mCurrentTransaction!!.commitNowAllowingStateLoss()
        mCurrentTransaction = null
      }
    }

    override fun setPrimaryItem(
      container: ViewGroup,
      position: Int,
      `object`: Any
    ) {
      val fragment = `object` as Fragment
      if (fragment !== mCurrentPrimaryItem) {
        if (mCurrentPrimaryItem != null) {
          mCurrentPrimaryItem!!.setMenuVisibility(false)
          mCurrentPrimaryItem!!.userVisibleHint = false
        }
//        if (fragment != null) {
        fragment.setMenuVisibility(true)
        fragment.userVisibleHint = true
//        }
        mCurrentPrimaryItem = fragment
      }
    }

    private fun makeFragmentName(
      viewId: Int,
      id: Long
    ): String {
      return "HomeViewPagerFragment:$viewId:$id"
    }
  }

}
