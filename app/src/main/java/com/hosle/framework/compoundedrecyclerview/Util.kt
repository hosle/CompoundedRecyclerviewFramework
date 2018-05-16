package com.hosle.framework.compoundedrecyclerview

import android.content.Context

/**
 * Created by tanjiahao on 2018/5/16
 * Original Project CompoundedRecyclerView
 */
fun dp2px(context: Context, dpValue: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}