package com.mobivention.gon.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.mobivention.myapplication.R

class RoundedImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {


    override fun setImageResource(resId: Int) {
        setBackgroundResource(R.drawable.outline)
        clipToOutline = true
        super.setImageResource(resId)
    }

}