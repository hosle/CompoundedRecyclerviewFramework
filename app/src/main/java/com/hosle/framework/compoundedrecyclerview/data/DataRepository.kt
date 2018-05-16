package com.hosle.framework.compoundedrecyclerview.data

import com.hosle.framework.compoundedrecyclerview.R
import com.hosle.framework.compoundedrecyclerview.model.*

/**
 * Created by tanjiahao on 2018/5/16
 * Original Project CompoundedRecyclerView
 */
class DataRepository{
    fun getMockDataList(): ArrayList<HomeModel>{
        return arrayListOf<HomeModel>(
                BannerModel(arrayListOf<BannerItemModel>(
                        BannerItemModel(R.drawable.sample_img_2),
                        BannerItemModel(R.drawable.sample_img_3),
                        BannerItemModel(R.drawable.sample_img_4)
                )),
                CategoryTitleModel("Cross-slide List 横向列表"),
                CrossSlideSectionModel(arrayListOf<CardItemModel>(
                        CardItemModel("Name名称1", R.drawable.sample_img),
                        CardItemModel("Name名称2",R.drawable.sample_img),
                        CardItemModel("Name名称3",R.drawable.sample_img),
                        CardItemModel("Name名称4",R.drawable.sample_img),
                        CardItemModel("Name名称5",R.drawable.sample_img)
                )),
                CrossCategoryNameSectionModel(arrayListOf<CrossCategoryNameSectionItemModel>(
                        CrossCategoryNameSectionItemModel("All"),
                        CrossCategoryNameSectionItemModel("CATG1"),
                        CrossCategoryNameSectionItemModel("CATG2"),
                        CrossCategoryNameSectionItemModel("CATG3"),
                        CrossCategoryNameSectionItemModel("CATG4"),
                        CrossCategoryNameSectionItemModel("CATG5")
                )),
                CardItemModel("Name名称1",R.drawable.sample_img),
                CardItemModel("Name名称2",R.drawable.sample_img),
                CardItemModel("Name名称3",R.drawable.sample_img),
                CardItemModel("Name名称31",R.drawable.sample_img),
                CardItemModel("Name名称32",R.drawable.sample_img),
                CardItemModel("Name名称33",R.drawable.sample_img),
                CardItemModel("Name名称34",R.drawable.sample_img),
                CardItemModel("Name名称4",R.drawable.sample_img),
                CardItemModel("Name名称41",R.drawable.sample_img),
                CardItemModel("Name名称42",R.drawable.sample_img),
                CardItemModel("Name名称43",R.drawable.sample_img),
                CardItemModel("Name名称44",R.drawable.sample_img),
                CardItemModel("Name名称5",R.drawable.sample_img)
        )
    }
}