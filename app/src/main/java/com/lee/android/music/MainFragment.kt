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
class MainFragment : BaseEpoxyFragment() {
  val viewModel: MainViewModel by fragmentViewModel()

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
//    super.onViewCreated(view, savedInstanceState)
    topBarLayout.visibility = View.GONE
    viewModel.asyncSubscribe(MainState::musics, onFail = { error ->
      toast("musics is fail")
      Timber.w(error)
    })
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
  }

  override fun epoxyController() = simpleController(viewModel) { state ->
    val musics = state.musics.invoke()
    if (musics?.playlists != null && musics.playlists.isNotEmpty()) {
      musics.playlists.forEachIndexed { index, playlistsItem ->
        basicRow {
          id("music$index")
          title(playlistsItem.name)
          subtitle(playlistsItem.description)
        }
      }
    }

  }
}