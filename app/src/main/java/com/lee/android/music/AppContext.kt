package com.lee.android.music

import android.support.multidex.MultiDexApplication
import android.util.Log
import com.lee.android.music.code.initNetEaseApi
import com.lee.android.music.code.initOkHttpClient
import com.lee.android.music.libs.FakeCrashLibrary
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import timber.log.Timber

/**
 * 作者：凌章 on 2018/9/3 16:17
 * 邮箱：lilingzhang@longshine.com
 */
class AppContext : MultiDexApplication() {
  private val okHttpClient = initOkHttpClient()
  private val netEaseServiceModule: Module = initNetEaseApi(okHttpClient)

  override fun onCreate() {
    super.onCreate()
    initLog()
    startKoin(this, listOf(netEaseServiceModule))
  }

  private fun initLog() {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    } else {
      Timber.plant(CrashReportingTree())
    }
  }

  private class CrashReportingTree : Timber.Tree() {
    override fun log(
      priority: Int,
      tag: String?,
      message: String,
      t: Throwable?
    ) {
      if (priority == Log.VERBOSE || priority == Log.DEBUG) {
        return
      }

      FakeCrashLibrary.log(priority, tag, message)

      if (t != null) {
        if (priority == Log.ERROR) {
          FakeCrashLibrary.logError(t)
        } else if (priority == Log.WARN) {
          FakeCrashLibrary.logWarning(t)
        }
      }
    }
  }
}