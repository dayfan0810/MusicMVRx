package com.lee.android.music.vo

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

/**
 * 作者：凌章 on 2018/9/3 16:44
 * 邮箱：lilingzhang@longshine.com
 */
data class PlaylistsItem(
  @Json(name = "description")
  val description: String = "",
  @Json(name = "privacy")
  val privacy: Int = 0,
  @Json(name = "trackNumberUpdateTime")
  val trackNumberUpdateTime: Long = 0,
  @Json(name = "subscribed")
  val subscribed: Any? = null,
  @Json(name = "shareCount")
  val shareCount: Int = 0,
  @Json(name = "trackCount")
  val trackCount: Int = 0,
  @Json(name = "adType")
  val adType: Int = 0,
  @Json(name = "coverImgId_str")
  val coverImgIdStr: String = "",
  @Json(name = "specialType")
  val specialType: Int = 0,
  @Json(name = "copywriter")
  val copywriter: String = "",
  @Json(name = "id")
  val id: Long = 0,
  @Json(name = "tag")
  val tag: String = "",
  @Json(name = "totalDuration")
  val totalDuration: Int = 0,
  @Json(name = "ordered")
  val ordered: Boolean = false,
  @Json(name = "creator")
  val creator: Creator,
  @Json(name = "subscribers")
  val subscribers: MutableList<SubscribersItem>?,
  @Json(name = "commentThreadId")
  val commentThreadId: String = "",
  @Json(name = "highQuality")
  val highQuality: Boolean = false,
  @Json(name = "updateTime")
  val updateTime: Long = 0,
  @Json(name = "trackUpdateTime")
  val trackUpdateTime: Long = 0,
  @Json(name = "userId")
  val userId: Int = 0,
  @Json(name = "tracks")
  val tracks: MutableList<TracksItem>? = null,
  @Json(name = "tags")
  val tags: MutableList<String>?,
  @Json(name = "anonimous")
  val anonimous: Boolean = false,
  @Json(name = "commentCount")
  val commentCount: Int = 0,
  @Json(name = "cloudTrackCount")
  val cloudTrackCount: Int = 0,
  @Json(name = "coverImgUrl")
  val coverImgUrl: String = "",
  @Json(name = "playCount")
  val playCount: Int = 0,
  @Json(name = "coverImgId")
  val coverImgId: Long = 0,
  @Json(name = "createTime")
  val createTime: Long = 0,
  @Json(name = "name")
  val name: String = "",
  @Json(name = "subscribedCount")
  val subscribedCount: Int = 0,
  @Json(name = "status")
  val status: Int = 0,
  @Json(name = "newImported")
  val newImported: Boolean = false
)

data class Creator(
  @Json(name = "birthday")
  val birthday: Long = 0,
  @Json(name = "detailDescription")
  val detailDescription: String = "",
  @Json(name = "backgroundUrl")
  val backgroundUrl: String = "",
  @Json(name = "gender")
  val gender: Int = 0,
  @Json(name = "city")
  val city: Int = 0,
  @Json(name = "signature")
  val signature: String = "",
  @Json(name = "description")
  val description: String = "",
  @Json(name = "remarkName")
  val remarkName: String? = null,
  @Json(name = "accountStatus")
  val accountStatus: Int = 0,
  @Json(name = "avatarImgId")
  val avatarImgId: Long = 0,
  @Json(name = "defaultAvatar")
  val defaultAvatar: Boolean = false,
  @Json(name = "backgroundImgIdStr")
  val backgroundImgIdStr: String = "",
  @Json(name = "avatarImgIdStr")
  val avatarImgIdstr: String = "",
  @Json(name = "province")
  val province: Int = 0,
  @Json(name = "nickname")
  val nickname: String = "",
  @Json(name = "expertTags")
  val expertTags: MutableList<String>?,
  @Json(name = "djStatus")
  val djStatus: Int = 0,
  @Json(name = "avatarUrl")
  val avatarUrl: String = "",
  @Json(name = "authStatus")
  val authStatus: Int = 0,
  @Json(name = "vipType")
  val vipType: Int = 0,
  @Json(name = "followed")
  val followed: Boolean = false,
  @Json(name = "userId")
  val userId: Int = 0,
  @Json(name = "mutual")
  val mutual: Boolean = false,
  @Json(name = "avatarImgId_str")
  val avatarImgIdStr: String = "",
  @Json(name = "authority")
  val authority: Int = 0,
  @Json(name = "userType")
  val userType: Int = 0,
  @Json(name = "backgroundImgId")
  val backgroundImgId: Long = 0
)

data class SubscribersItem(
  @Json(name = "birthday")
  val birthday: Long = 0,
  @Json(name = "detailDescription")
  val detailDescription: String = "",
  @Json(name = "backgroundUrl")
  val backgroundUrl: String = "",
  @Json(name = "gender")
  val gender: Int = 0,
  @Json(name = "city")
  val city: Int = 0,
  @Json(name = "signature")
  val signature: String = "",
  @Json(name = "description")
  val description: String = "",
  @Json(name = "remarkName")
  val remarkName: String? = "",
  @Json(name = "accountStatus")
  val accountStatus: Int = 0,
  @Json(name = "avatarImgId")
  val avatarImgId: Long = 0,
  @Json(name = "defaultAvatar")
  val defaultAvatar: Boolean = false,
  @Json(name = "backgroundImgIdStr")
  val backgroundImgIdStr: String = "",
  @Json(name = "avatarImgIdStr")
  val avatarImgIdSt: String = "",
  @Json(name = "province")
  val province: Int = 0,
  @Json(name = "nickname")
  val nickname: String = "",
  @Json(name = "expertTags")
  val expertTags: Any? = null,
  @Json(name = "djStatus")
  val djStatus: Int = 0,
  @Json(name = "avatarUrl")
  val avatarUrl: String = "",
  @Json(name = "authStatus")
  val authStatus: Int = 0,
  @Json(name = "vipType")
  val vipType: Int = 0,
  @Json(name = "followed")
  val followed: Boolean = false,
  @Json(name = "userId")
  val userId: Int = 0,
  @Json(name = "mutual")
  val mutual: Boolean = false,
  @Json(name = "avatarImgId_str")
  val avatarImgIdStr: String = "",
  @Json(name = "authority")
  val authority: Int = 0,
  @Json(name = "userType")
  val userType: Int = 0,
  @Json(name = "backgroundImgId")
  val backgroundImgId: Long = 0,
  @Json(name = "experts")
  val experts: Any? = null
)

data class NeteasePlaylist(
  @Json(name = "lasttime")
  val lasttime: Long = 0,
  @Json(name = "total")
  val total: Int = 0,
  @Json(name = "code")
  val code: Int = 0,
  @Json(name = "more")
  val more: Boolean = false,
  @Json(name = "playlists")
  val playlists: MutableList<PlaylistsItem>? = mutableListOf()
)

data class NeteasePlaylistDetail(
  @Json(name = "code")
  val code: Int = 0,
  @Json(name = "playlist")
  val playlist: PlaylistsItem?
)

data class TracksItem(
  @Json(name = "id")
  val id: String?,
  @Json(name = "name")
  val name: String? = "",
  @Json(name = "ar")
  val artists: MutableList<ArtistsItem>?,
  @Json(name = "al")
  val album: AlbumItem,
  @Json(name = "publishTime")
  val publishTime: Long = 0,
  @Json(name = "cp")
  val cp: Int = 0
)

data class AlbumItem(
  @Json(name = "picUrl")
  val picUrl: String = "",
  @Json(name = "name")
  val name: String = "",
  @Json(name = "id")
  val id: Int = 0
)