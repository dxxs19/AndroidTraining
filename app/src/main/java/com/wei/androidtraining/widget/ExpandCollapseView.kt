package com.wei.androidtraining.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.wei.androidtraining.MainActivity
import com.wei.androidtraining.R

/**
 *
 * @author XiangWei
 * @since 2019/8/21
 */
class ExpandCollapseView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    companion object {
        private const val EXPAND = "展开"
        private const val COLLAPSE = "收起"
        private const val LIMIT_LINES = 4
    }

    private var tvContent: TextView? = null
    private var tvExpandCollapse: TextView? = null
    private var originalText = ""
    private var layoutView: View? = null
    private var collapseText = ""

    init {
        layoutView = LayoutInflater.from(context).inflate(R.layout.layout_expand_collapse, this, true)
        initViews()
    }

    fun setTextContent(text: String) {
        originalText = text
        tvContent?.text = originalText
    }

    private fun initViews() {
        tvContent = layoutView?.findViewById(R.id.tv_content)
        tvExpandCollapse = layoutView?.findViewById(R.id.tv_expand_collapse)

        originalText = tvContent?.text.toString()
        initExpandView()

        tvExpandCollapse?.setOnClickListener {
            if (tvExpandCollapse?.text == EXPAND) {
                val originalLines = tvContent?.lineCount ?: 0

                tvContent?.text = originalText.plus("aaaa")
                val measureLines = tvContent?.lineCount ?: 0

                tvContent?.maxLines = measureLines

                tvContent?.text = originalText
                tvExpandCollapse?.text = COLLAPSE

                if (measureLines > originalLines) {
                    tvContent?.height = (tvContent?.lineHeight ?: 0) * measureLines + 10
                }
            } else {
                tvContent?.maxLines = LIMIT_LINES
                tvExpandCollapse?.text = EXPAND
                tvContent?.height = (tvContent?.lineHeight ?: 0) * LIMIT_LINES + 15
                tvContent?.text = collapseText
            }
        }
    }

    private fun initExpandView() {
        tvContent?.text = originalText.plus("aaaa")

        tvContent?.postDelayed({
            val measureLines = tvContent?.lineCount ?: 0
            if (measureLines > LIMIT_LINES) {
                // 末尾显示 "...展开"
                val lineEndIndex = tvContent?.layout?.getLineEnd(LIMIT_LINES - 1)
                collapseText = lineEndIndex?.minus(10)?.let { originalText.substring(0, it).plus("...") }.toString()
                tvContent?.text = collapseText
            } else { // 不用显示 "...展开"
                tvExpandCollapse?.visibility = View.GONE
            }
        }, 50)
    }

}