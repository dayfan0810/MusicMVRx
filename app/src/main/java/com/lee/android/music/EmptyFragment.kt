package com.lee.android.music

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.lee.android.music.code.BaseEpoxyFragment
import com.lee.android.music.code.MvRxEpoxyController
import com.lee.android.music.code.simpleController
import com.lee.android.music.code.toast
import com.lee.android.music.views.basicRow
import timber.log.Timber

/**
 * 作者：凌章 on 2018/9/3 17:09
 * 邮箱：lilingzhang@longshine.com
 */
class EmptyFragment : BaseEpoxyFragment() {

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    topBarLayout.visibility = View.GONE
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
  }

  override fun epoxyController() = simpleController {

  }
}