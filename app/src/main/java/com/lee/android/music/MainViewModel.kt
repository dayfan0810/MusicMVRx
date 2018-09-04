package com.lee.android.music

import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentActivity
import android.util.Log
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Uninitialized
import com.lee.android.music.code.MvRxViewModel
import com.lee.android.music.libs.glide.GlideRequest
import com.lee.android.music.network.NetEaseApiService
import com.lee.android.music.vo.NeteasePlaylist
import com.lee.android.music.vo.PlaylistsItem
import org.koin.android.ext.android.inject

/**
 * 作者：凌章 on 2018/9/3 17:32
 * 邮箱：lilingzhang@longshine.com
 */
data class MainState(
  val musics: List<PlaylistsItem> = emptyList(),//musics
  val request: Async<NeteasePlaylist> = Uninitialized
) : MvRxState

class MainViewModel(
  initialState: MainState,
  private val netEaseService: NetEaseApiService
) : MvRxViewModel<MainState>(initialState) {
  init {
    fetchNextPage()
  }

  fun fetchNextPage() = withState { state ->
    if (state.request is Loading) return@withState
    netEaseService.getTopPlaylist("流行", 8)
        .execute { copy(request = it, musics = musics+(it()?.playlists ?: emptyList())) }
  }

  companion object : MvRxViewModelFactory<MainState> {
    @JvmStatic override fun create(
      activity: FragmentActivity,
      state: MainState
    ): BaseMvRxViewModel<MainState> {
      val service: NetEaseApiService by activity.inject()
      return MainViewModel(state, service)
    }
  }
}