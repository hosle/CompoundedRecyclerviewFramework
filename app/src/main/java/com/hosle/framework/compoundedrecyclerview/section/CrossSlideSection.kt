package com.hosle.framework.compoundedrecyclerview.section

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hosle.framework.compoundedrecyclerview.EventHandling
import com.hosle.framework.compoundedrecyclerview.R
import com.hosle.framework.compoundedrecyclerview.model.CardItemModel
import com.hosle.framework.compoundedrecyclerview.model.HomeModel
import com.hosle.framework.compoundedrecyclerview.model.CrossSlideSectionModel
import com.hosle.framework.compoundedrecyclerview.viewholder.BaseViewHolder
import com.hosle.framework.compoundedrecyclerview.viewholder.BindingViewHolder
import com.hosle.framework.compoundedrecyclerview.viewholder.HorizontalScrollingViewHolder

/**
 * Created by tanjiahao on 2018/5/9
 * Original Project CompoundedRecyclerView
 */
class CrossSlideSectionAdapterDelegate(val data:ArrayList<HomeModel>, val eventHandler: EventHandling) : SectionAdapterImp() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        return CrossSlideViewHolder(createView(parent, R.layout.section_cross), eventHandler)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        val goodsDataList = data[position]
        if (goodsDataList is CrossSlideSectionModel) {
            (holder as CrossSlideViewHolder).refreshData(goodsDataList.horizontalData)
        }
    }
}

class CrossSlideViewHolder(rootView : View, eventHandling: EventHandling): HorizontalScrollingViewHolder<CardItemModel>(rootView){

    init {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(rootView.context, LinearLayoutManager.HORIZONTAL,false)

            adapter = CrossSlideContentAdapter(data, eventHandling)

            addItemDecoration(with(DividerItemDecoration(rootView.context, DividerItemDecoration.HORIZONTAL)) {
                setDrawable(ContextCompat.getDrawable(rootView.context, R.drawable.divider_decoration_vertical))
                this
            })
        }
    }

    override fun refreshData(newData : ArrayList<CardItemModel>){
        data.clear()
        data.addAll(newData)
        recyclerView.adapter.notifyDataSetChanged()
    }
}

class CrossSlideContentAdapter(val data:ArrayList<CardItemModel>, val eventHandling: EventHandling) : RecyclerView.Adapter<BindingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BindingViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val binding: ViewDataBinding =
                DataBindingUtil.inflate(inflater, R.layout.item_cross_slide_card, parent, false)

        return BindingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BindingViewHolder?, position: Int) {
        data[position].index = position
        holder!!.bind(data[position])
        holder.bindEventHandler(eventHandling)
    }
}