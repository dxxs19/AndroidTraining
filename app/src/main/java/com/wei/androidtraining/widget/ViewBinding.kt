package com.wei.androidtraining.widget

import android.databinding.BindingAdapter
import android.widget.TextView

/**
 *
 * @author XiangWei
 * @since 2018/11/15
 */
object ViewBinding {

    private const val TEXTCOLOR = BINDING_PREFIX + "textColor"
    private const val TEXT_CONTENT = BINDING_PREFIX + "text_content"

    @JvmStatic
    @BindingAdapter(TEXTCOLOR)
    fun setTextColor(view: CusTextView, color: Int) {
        view.setColor(color)
    }

    @JvmStatic
    @BindingAdapter(TEXT_CONTENT)
    fun setTextContent(view: ExpandCollapseView, text: String) {
        view.setTextContent(text)
    }
}