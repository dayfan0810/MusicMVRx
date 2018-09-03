package com.lee.android.music

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout.Tab
import android.view.Gravity
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.qmuiteam.qmui.widget.QMUITopBarLayout
import kotlinx.android.synthetic.main.activity_main.drawerLayout
import kotlinx.android.synthetic.main.activity_main.navigation
import kotlinx.android.synthetic.main.activity_main.tabs
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
      tabs.addTab(tabs.newTab().setText("发现"))
      tabs.addTab(tabs.newTab().setText("我的"))
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

}
