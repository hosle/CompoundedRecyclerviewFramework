package com.hosle.framework.compoundedrecyclerview.viewholder

import android.databinding.ViewDataBinding
import com.hosle.framework.compoundedrecyclerview.BR

/**
 * Created by tanjiahao on 2018/5/15
 * Original Project CompoundedRecyclerView
 */
class BindingViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding.root) {
    fun bind(data: Any) {
        binding.setVariable(BR.data, data)
        binding.executePendingBindings()
    }

    fun bindEventHandler(eventhandler:Any){
        binding.setVariable(BR.eventHandler,eventhandler)
        binding.executePendingBindings()
    }

    fun bindSelected(selection:Any){
        binding.setVariable(BR.selectedPosition,selection)
        binding.executePendingBindings()
    }
}