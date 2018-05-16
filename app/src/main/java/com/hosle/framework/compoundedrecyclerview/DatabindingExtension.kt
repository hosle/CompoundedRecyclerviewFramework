package com.hosle.framework.compoundedrecyclerview

import android.databinding.BindingAdapter
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.graphics.Bitmap
import android.widget.ImageView


/**
 * Created by tanjiahao on 2018/5/8
 * Original Project CompoundedRecyclerView
 */

@BindingAdapter("android:layout_marginRight")
fun setMarginRight(view: View, value: Float) {
    val layoutParams = view.layoutParams as MarginLayoutParams
    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin,
            Math.round(value), layoutParams.bottomMargin)
    view.layoutParams = layoutParams
}

@BindingAdapter("android:layout_marginLeft")
fun setMarginLeft(view: View, value: Float) {
    val layoutParams = view.layoutParams as MarginLayoutParams
    layoutParams.setMargins(Math.round(value), layoutParams.topMargin,
            layoutParams.rightMargin, layoutParams.bottomMargin)
    view.layoutParams = layoutParams
}

@BindingAdapter("android:layout_marginTop")
fun setMarginTop(view: View, value: Float) {
    val layoutParams = view.layoutParams as MarginLayoutParams
    layoutParams.setMargins(layoutParams.leftMargin, Math.round(value),
            layoutParams.rightMargin, layoutParams.bottomMargin)
    view.layoutParams = layoutParams
}

@BindingAdapter("android:layout_marginBottom")
fun setMarginBottom(view: View, value: Float) {
    val layoutParams = view.layoutParams as MarginLayoutParams
    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin,
            layoutParams.rightMargin, Math.round(value))
    view.layoutParams = layoutParams
}

@BindingAdapter("android:layout_paddingBottom")
fun setPaddingBottom(view: View, value: Int) {
    view.setPadding(view.paddingLeft, view.paddingTop, view.paddingRight, value)
}

@BindingAdapter("android:layout_paddingTop")
fun setPaddingTop(view: View, value: Int) {
    view.setPadding(view.paddingLeft, value, view.paddingRight, view.paddingBottom)
}

@BindingAdapter("android:layout_height")
fun setHeight(view: View, value: Float) {
    val layoutParams = view.layoutParams
    layoutParams.height = Math.round(value)
    view.layoutParams = layoutParams
}

@BindingAdapter("android:src")
fun setSrc(view: ImageView, resId: Int) {
    view.setImageResource(resId)
}

@BindingAdapter("remoteURL")
fun loadRemoteImage(imageView: ImageView, url: String) {
    if (url != "") {
//        Glide.with(imageView.context)
//                .load(url)
//            .apply(RequestOptions().placeholder(placeHolder).error(error))
//                .into(imageView)
    }
}

fun loadRemoteTopRoundCornerImage(imageView: ImageView, url: String, radius: Float) {
//    Glide.with(imageView.context)
//            .load(url)
//            .apply(RequestOptions().transform(GlideRoundCornerTransformer(imageView.context, radius)))
//            .into(imageView)
}