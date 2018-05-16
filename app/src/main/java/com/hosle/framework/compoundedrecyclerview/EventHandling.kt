package com.hosle.framework.compoundedrecyclerview

import com.hosle.framework.compoundedrecyclerview.model.CrossCategoryNameSectionItemModel
import com.hosle.framework.compoundedrecyclerview.model.CardItemModel

/**
 * Created by tanjiahao on 2018/5/11
 * Original Project CompoundedRecyclerView
 */
interface EventHandling {
    fun onItemClick(itemModel: CardItemModel)
    fun onCategoryChanged(itemModel: CrossCategoryNameSectionItemModel)
}