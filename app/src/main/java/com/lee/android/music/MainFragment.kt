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
import com.lee.android.music.views.loadMoreRow
import kotlinx.android.synthetic.main.fragment_base_epoxy_mvrx.swipeRefreshLayout
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
    swipeRefreshLayout.setColorSchemeResources(R.color.app_color_blue)
    viewModel.asyncSubscribe(MainState::request, onFail = { error ->
      toast("musics is fail")
      swipeRefreshLayout.isRefreshing = false
      Timber.w(error)
    })
    swipeRefreshLayout.setOnRefreshListener {
      viewModel.fetchNextPage()
    }
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
  }

  override fun epoxyController() = simpleController(viewModel) { state ->
    //    val musics = state.request.invoke()
//    if (musics?.playlists != null && musics.playlists.isNotEmpty()) {
//      musics.playlists.forEachIndexed { index, playlistsItem ->
//        basicRow {
//          id("music$index")
//          title(playlistsItem.name)
//          subtitle(playlistsItem.description)
//          image(playlistsItem.coverImgUrl)
//        }
//      }
    state.musics.forEachIndexed { index, music ->
      basicRow {
        id("music$index")
        title(music.name)
        subtitle(music.description)
        image(music.coverImgUrl)
      }
    }
    swipeRefreshLayout.isRefreshing = false
    if (state.musics.size>3)
    loadMoreRow {
      id("loading${state.musics.size}")
      onBind { _, _, _ -> viewModel.fetchNextPage() }
    }
  }

}