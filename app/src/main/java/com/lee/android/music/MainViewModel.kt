package com.lee.android.music

import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentActivity
import android.util.Log
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Uninitialized
import com.lee.android.music.code.MvRxViewModel
import com.lee.android.music.network.NetEaseApiService
import com.lee.android.music.vo.NeteasePlaylist
import org.koin.android.ext.android.inject

/**
 * 作者：凌章 on 2018/9/3 17:32
 * 邮箱：lilingzhang@longshine.com
 */
data class MainState(val musics: Async<NeteasePlaylist> = Uninitialized) : MvRxState

class MainViewModel(
  initialState: MainState,
  private val netEaseService: NetEaseApiService
) : MvRxViewModel<MainState>(initialState) {
  init {
    musics()
  }

  fun musics() = withState { state ->
    netEaseService.getTopPlaylist("流行", 20)
        .execute { copy(musics = it) }
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