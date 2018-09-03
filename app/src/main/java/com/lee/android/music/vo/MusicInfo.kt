package com.lee.android.music.vo

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

/**
 * 作者：凌章 on 2018/9/3 16:47
 * 邮箱：lilingzhang@longshine.com
 */
data class ArtistsItem(
  @Json(name ="id")
  val id: String = "",
  @Json(name ="name")
  val name: String = ""
)

data class Album(
  @Json(name ="id")
  val id: String? = "",
  @Json(name ="name")
  val name: String? = "",
  @Json(name ="cover")
  val cover: String? = ""
)

data class MusicInfo(
  @Json(name ="id")
  val id: String?,
  @Json(name ="songId")
  val songId: String?,
  @Json(name ="name")
  val name: String? = "",
  @Json(name ="artists")
  val artists: List<ArtistsItem>?,
  @Json(name ="album")
  val album: Album,
  @Json(name ="vendor")
  val vendor: String? = "",
  @Json(name ="commentId")
  val commentId: String? = "",
  @Json(name ="cp")
  val cp: Boolean = false
)

data class CollectBatchBean(
  @Json(name ="ids")
  val ids: List<String>? = null,
  @Json(name ="vendor")
  val vendor: String? = null
)

data class CollectBatch2Bean(
  @Json(name ="collects")
  val collects: MutableList<CollectDetail>? = null
)

data class CollectDetail(
  @Json(name ="id")
  val id: String,
  @Json(name ="vendor")
  val vendor: String
)

data class CollectResult(
  @Json(name ="failedList")
  val failedList: List<String>?
)