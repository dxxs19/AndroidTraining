package com.wei.androidtraining.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

/**
 *
 * @author XiangWei
 * @since 2018/11/15
 */
class CusTextView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr){


    fun setColor(color: Int) {
        setTextColor(context.resources.getColor(color))
    }
}