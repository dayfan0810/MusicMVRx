package com.lee.android.music.code

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import com.lee.android.music.BuildConfig
import com.lee.android.music.R
import com.lee.android.music.network.NetEaseApiService
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import com.squareup.moshi.Moshi.Builder
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.Module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * 作者：凌章 on 2018/8/31 09:48
 * 邮箱：lilingzhang@longshine.com
 * 扩展函数
 */

fun Fragment.toast(
  message: CharSequence,
  duration: Int = Toast.LENGTH_SHORT
) {
  Toast.makeText(activity, message, duration)
      .show()
}

fun Activity.toast(
  message: CharSequence,
  duration: Int = Toast.LENGTH_SHORT
) {
  Toast.makeText(this, message, duration)
      .show()
}

fun Fragment.loading(): QMUITipDialog {
  return QMUITipDialog.Builder(activity)
      .setIconType(
          QMUITipDialog.Builder.ICON_TYPE_LOADING
      )
      .setTipWord(getString(R.string.loading))
      .create()
}

fun Activity.loading(): QMUITipDialog {
  return QMUITipDialog.Builder(this)
      .setIconType(
          QMUITipDialog.Builder.ICON_TYPE_LOADING
      )
      .setTipWord(getString(R.string.loading))
      .create()
}

fun EditText.setTextChangeListener(body: (key: String) -> Unit) {
  addTextChangedListener(object : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(
      s: CharSequence?,
      start: Int,
      count: Int,
      after: Int
    ) {
    }

    override fun onTextChanged(
      s: CharSequence?,
      start: Int,
      before: Int,
      count: Int
    ) {
      body(s.toString())
    }
  })
}

fun Application.initHttpLoggingInterceptor(): HttpLoggingInterceptor {
  val interceptor = HttpLoggingInterceptor()
  if (BuildConfig.DEBUG) {
    interceptor.level = HttpLoggingInterceptor.Level.BODY
  } else {
    interceptor.level = HttpLoggingInterceptor.Level.NONE
  }
  return interceptor
}

fun Application.initOkHttpClient(): OkHttpClient {
  return OkHttpClient.Builder()
      .addInterceptor(initHttpLoggingInterceptor())
      .build()
}

fun initNetEaseApi(okHttpClient: OkHttpClient): Module {

  return org.koin.dsl.module.applicationContext {
    bean {
      val moshi = Builder()
          .add(KotlinJsonAdapterFactory())
          .build()
      val retrofit = Retrofit.Builder()
          .client(okHttpClient)
          .baseUrl("https://netease.api.zzsun.cc/")
          .addConverterFactory(MoshiConverterFactory.create(moshi))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .build()
      retrofit.create(NetEaseApiService::class.java)
    }
  }
}