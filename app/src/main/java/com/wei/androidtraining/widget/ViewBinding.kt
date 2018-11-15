package com.wei.androidtraining.widget

import android.databinding.BindingAdapter
import android.widget.TextView

/**
 *
 * @author XiangWei
 * @since 2018/11/15
 */
object ViewBinding {

    private const val TEXTCOLOR = "textColor"

    @JvmStatic
    @BindingAdapter(TEXTCOLOR)
    fun setTextColor(view: CusTextView, color: Int) {
        view.setColor(color)
    }

}