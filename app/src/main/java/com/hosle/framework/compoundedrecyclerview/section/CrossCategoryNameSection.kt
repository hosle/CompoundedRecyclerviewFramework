package com.hosle.framework.compoundedrecyclerview.section

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hosle.framework.compoundedrecyclerview.EventHandling
import com.hosle.framework.compoundedrecyclerview.R
import com.hosle.framework.compoundedrecyclerview.model.CrossCategoryNameSectionItemModel
import com.hosle.framework.compoundedrecyclerview.model.CrossCategoryNameSectionModel
import com.hosle.framework.compoundedrecyclerview.model.HomeModel
import com.hosle.framework.compoundedrecyclerview.viewholder.BaseViewHolder
import com.hosle.framework.compoundedrecyclerview.viewholder.BindingViewHolder
import com.hosle.framework.compoundedrecyclerview.viewholder.HorizontalScrollingViewHolder

/**
 * Created by tanjiahao on 2018/5/9
 * Original Project CompoundedRecyclerView
 */
class CrossCategoryNameSectionAdapterDelegate(val data:ArrayList<HomeModel>, val eventHandler: EventHandling) : SectionAdapterImp() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        return CrossCategoryNameSectionViewHolder(createView(parent, R.layout.section_cross), eventHandler)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        val categoryNames = data[position]
        if (categoryNames is CrossCategoryNameSectionModel) {
            (holder as CrossCategoryNameSectionViewHolder).refreshData(categoryNames.horizontalData)
        }
    }
}

class CrossCategoryNameSectionViewHolder(view: View, eventHandling: EventHandling): HorizontalScrollingViewHolder<CrossCategoryNameSectionItemModel>(view){

    init {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(rootView.context, LinearLayoutManager.HORIZONTAL,false)

            adapter = CrossCategoryNameContentAdapter(data, eventHandling)
        }
    }

    override fun refreshData(newData : ArrayList<CrossCategoryNameSectionItemModel>){
        data.clear()
        data.addAll(newData)
        recyclerView.adapter.notifyDataSetChanged()
    }
}

class CrossCategoryNameContentAdapter(val data:ArrayList<CrossCategoryNameSectionItemModel>, val eventHandling: EventHandling) : RecyclerView.Adapter<BindingViewHolder>() {

    private var selectedPos:Int = 0
    private val contantFirstPage = 1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BindingViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val binding: ViewDataBinding =
                DataBindingUtil.inflate(inflater, R.layout.item_category_name, parent, false)

        return BindingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BindingViewHolder?, position: Int) {
        data[position].index = position

        holder!!.bind(data[position])
        holder.bindSelected(selectedPos)
        holder.bindEventHandler(View.OnClickListener {
            selectedPos = position
            notifyDataSetChanged()
            eventHandling.onCategoryChanged(data[position])
        })
    }
}