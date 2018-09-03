package com.lee.android.music.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.bumptech.glide.Glide
import com.lee.android.music.R
import com.lee.android.music.libs.glide.GlideApp

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class BasicRow @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

  private val titleView: TextView
  private val imageView: ImageView

  private val subtitleView: TextView

  init {
    inflate(context, R.layout.basic_row, this)
    titleView = findViewById(R.id.title)
    subtitleView = findViewById(R.id.subtitle)
    imageView = findViewById(R.id.image)
    orientation = VERTICAL
  }

  @TextProp
  fun setTitle(title: CharSequence) {
    titleView.text = title
  }

  @ModelProp
  fun setImage(url: String) {
    Glide.with(this).load(url).into(imageView)
  }

  @TextProp
  fun setSubtitle(subtitle: CharSequence?) {
    subtitleView.visibility = if (subtitle.isNullOrBlank()) View.GONE else View.VISIBLE
    subtitleView.text = subtitle
  }

  @CallbackProp
  fun setClickListener(clickListener: OnClickListener?) {
    setOnClickListener(clickListener)
  }
}