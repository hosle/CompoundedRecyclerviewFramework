package com.hosle.framework.compoundedrecyclerview.section

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hosle.framework.compoundedrecyclerview.viewholder.BaseViewHolder
import com.hosle.framework.compoundedrecyclerview.viewholder.BindingViewHolder

/**
 * Created by tanjiahao on 2018/5/15
 * Original Project CompoundedRecyclerView
 */
abstract class SectionAdapterImp : RecyclerView.Adapter<BaseViewHolder>(){

    fun createView(parent: ViewGroup?, resId: Int): View {
        val inflater = LayoutInflater.from(parent!!.context)
        return inflater.inflate(resId, parent, false)
    }

    fun createBindingViewHolder(resId: Int,parent: ViewGroup?): BindingViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val binding : ViewDataBinding = DataBindingUtil.inflate(inflater, resId, parent, false)
        return BindingViewHolder(binding)
    }
}