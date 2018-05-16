package com.hosle.framework.compoundedrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.hosle.framework.compoundedrecyclerview.data.DataRepository
import com.hosle.framework.compoundedrecyclerview.model.CrossCategoryNameSectionItemModel
import com.hosle.framework.compoundedrecyclerview.model.CardItemModel
import com.hosle.framework.compoundedrecyclerview.model.HomeModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), EventHandling {


    val listData= ArrayList<HomeModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView(){

        recycler_view.apply {
            layoutManager = GridLayoutManager(this@MainActivity,2, GridLayoutManager.VERTICAL,false)
            adapter = MainAdapter(listData,this@MainActivity)

        }
    }

    private fun initData(){
        listData.addAll(DataRepository().getMockDataList())
    }

    override fun onItemClick(itemModel: CardItemModel) {

    }

    override fun onCategoryChanged(itemModel: CrossCategoryNameSectionItemModel) {

    }
}
