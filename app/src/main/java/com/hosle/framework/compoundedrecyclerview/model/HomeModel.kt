package com.hosle.framework.compoundedrecyclerview.model

/**
 * Created by tanjiahao on 2018/5/7
 * Original Project CompoundedRecyclerView
 */

open class HomeModel(var index: Int = 0)
open class HomeHorizontalModel<T>(val horizontalData:ArrayList<T>) : HomeModel()

data class BannerModel(val data:ArrayList<BannerItemModel>):HomeModel()
data class BannerItemModel(val picRes:Int, val jumpUrl:String = "")

data class CategoryTitleModel(val name:String):HomeModel()

class CrossSlideSectionModel(data:ArrayList<CardItemModel>):HomeHorizontalModel<CardItemModel>(data)
open class CardItemModel(val name:String, val picRes:Int):HomeModel()

class CrossCategoryNameSectionModel(data:ArrayList<CrossCategoryNameSectionItemModel>):HomeHorizontalModel<CrossCategoryNameSectionItemModel>(data)
data class CrossCategoryNameSectionItemModel(val name:String, var index:Int = 0)
