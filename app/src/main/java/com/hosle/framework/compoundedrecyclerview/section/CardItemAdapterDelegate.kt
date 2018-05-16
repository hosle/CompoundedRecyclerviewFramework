package com.hosle.framework.compoundedrecyclerview.section

import android.view.ViewGroup
import com.hosle.framework.compoundedrecyclerview.EventHandling
import com.hosle.framework.compoundedrecyclerview.R
import com.hosle.framework.compoundedrecyclerview.model.CardItemModel
import com.hosle.framework.compoundedrecyclerview.model.HomeModel
import com.hosle.framework.compoundedrecyclerview.viewholder.BaseViewHolder
import com.hosle.framework.compoundedrecyclerview.viewholder.BindingViewHolder

/**
 * Created by tanjiahao on 2018/5/15
 * Original Project CompoundedRecyclerView
 */
class CardItemAdapterDelegate(val data:ArrayList<HomeModel>, val eventHandler: EventHandling) : SectionAdapterImp() {
    private var gridItemStartIndex :Int = 0

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        return createBindingViewHolder(R.layout.item_card, parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        updateGridItemStartIndex()

        (holder as BindingViewHolder).apply {
            data[position].index = position - gridItemStartIndex
            bind(data[position])
            bindEventHandler(eventHandler)
        }
    }

    private fun updateGridItemStartIndex(){
        gridItemStartIndex = (0 until data.size).firstOrNull { data[it] is CardItemModel }
                ?: 0
    }
}