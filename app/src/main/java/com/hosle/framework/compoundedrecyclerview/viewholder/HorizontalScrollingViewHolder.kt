package com.hosle.framework.compoundedrecyclerview.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by tanjiahao on 2018/5/8
 * Original Project CompoundedRecyclerView
 */
abstract class HorizontalScrollingViewHolder<T>(rootView: View) : BaseViewHolder(rootView) {
    var data = ArrayList<T>()

    val recyclerView: RecyclerView = rootView as RecyclerView

    open fun refreshData(newData: ArrayList<T>) {
        data.clear()
        data.addAll(newData)
    }
}