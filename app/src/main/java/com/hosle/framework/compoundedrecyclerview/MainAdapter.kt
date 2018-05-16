package com.hosle.framework.compoundedrecyclerview

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.hosle.framework.compoundedrecyclerview.model.*
import com.hosle.framework.compoundedrecyclerview.section.CrossCategoryNameSectionAdapterDelegate
import com.hosle.framework.compoundedrecyclerview.section.BannerAdapterDelegate
import com.hosle.framework.compoundedrecyclerview.section.SectionAdapterImp
import com.hosle.framework.compoundedrecyclerview.section.CrossSlideSectionAdapterDelegate
import com.hosle.framework.compoundedrecyclerview.section.CategoryTitleAdapterDelegate
import com.hosle.framework.compoundedrecyclerview.section.CardItemAdapterDelegate
import com.hosle.framework.compoundedrecyclerview.viewholder.BaseViewHolder

/**
 * Created by tanjiahao on 2018/5/7
 * Original Project CompoundedRecyclerView
 */
class MainAdapter(val data:ArrayList<HomeModel>, val eventHandler: EventHandling):RecyclerView.Adapter<BaseViewHolder>() {

    private val TYPE_BANNER = 1
    private val TYPE_CARD_ITEM = 2
    private val TYPE_CATEGORY_TITLE = 3
    private val TYPE_CROSS_SLIDE_SECTION = 4
    private val TYPE_CROSS_CATEGORY_NAME_SECTION = 5

    private val adapterDelegates = HashMap<Int, SectionAdapterImp>()

    init {
        adapterDelegates[TYPE_BANNER] = BannerAdapterDelegate(data, eventHandler)
        adapterDelegates[TYPE_CROSS_CATEGORY_NAME_SECTION] = CrossCategoryNameSectionAdapterDelegate(data, eventHandler)
        adapterDelegates[TYPE_CROSS_SLIDE_SECTION] = CrossSlideSectionAdapterDelegate(data, eventHandler)
        adapterDelegates[TYPE_CATEGORY_TITLE] = CategoryTitleAdapterDelegate(data, eventHandler)
        adapterDelegates[TYPE_CARD_ITEM] = CardItemAdapterDelegate(data, eventHandler)
    }

    override fun getItemViewType(position: Int): Int {

        return when(data[position]){
            is BannerModel -> TYPE_BANNER
            is CardItemModel -> TYPE_CARD_ITEM
            is CategoryTitleModel -> TYPE_CATEGORY_TITLE
            is CrossSlideSectionModel -> TYPE_CROSS_SLIDE_SECTION
            is CrossCategoryNameSectionModel -> TYPE_CROSS_CATEGORY_NAME_SECTION
            else -> TYPE_CARD_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        return  adapterDelegates[viewType]!!.onCreateViewHolder(parent,viewType)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        adapterDelegates[getItemViewType(position)]!!.onBindViewHolder(holder,position)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)

        val layoutManager = recyclerView?.layoutManager
        if(layoutManager is GridLayoutManager){
            layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
                override fun getSpanSize(position: Int): Int {
                    return when(getItemViewType(position)){
                        TYPE_CARD_ITEM -> 1
                        else -> layoutManager.spanCount
                    }
                }
            }
        }
    }
}