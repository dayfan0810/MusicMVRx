package com.lee.android.music.network

import com.lee.android.music.vo.NeteasePlaylist
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 作者：凌章 on 2018/9/3 16:40
 * 邮箱：lilingzhang@longshine.com
 */
interface NetEaseApiService {
  @GET("top/playlist")
  fun getTopPlaylist(
    @Query("cat") cat: String? = null, @Query(
        "limit"
    ) limit: Int
  ): Observable<NeteasePlaylist>
}