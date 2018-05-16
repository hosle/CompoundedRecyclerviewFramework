package com.hosle.framework.compoundedrecyclerview.section

import android.view.ViewGroup
import com.hosle.framework.compoundedrecyclerview.EventHandling
import com.hosle.framework.compoundedrecyclerview.R
import com.hosle.framework.compoundedrecyclerview.model.HomeModel
import com.hosle.framework.compoundedrecyclerview.viewholder.BaseViewHolder
import com.hosle.framework.compoundedrecyclerview.viewholder.BindingViewHolder

/**
 * Created by tanjiahao on 2018/5/15
 * Original Project CompoundedRecyclerView
 */
class CategoryTitleAdapterDelegate(val data:ArrayList<HomeModel>, val eventHandler: EventHandling) : SectionAdapterImp() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        return createBindingViewHolder(R.layout.item_category_title, parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        (holder as BindingViewHolder).apply {
            bind(data[position])
            bindEventHandler(eventHandler)
        }
    }
}