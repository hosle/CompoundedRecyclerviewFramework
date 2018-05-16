package com.hosle.framework.compoundedrecyclerview.section

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import com.hosle.framework.compoundedrecyclerview.EventHandling
import com.hosle.framework.compoundedrecyclerview.R
import com.hosle.framework.compoundedrecyclerview.dp2px
import com.hosle.framework.compoundedrecyclerview.model.BannerItemModel
import com.hosle.framework.compoundedrecyclerview.model.BannerModel
import com.hosle.framework.compoundedrecyclerview.model.HomeModel
import com.hosle.framework.compoundedrecyclerview.viewholder.BaseViewHolder

/**
 * Created by tanjiahao on 2018/5/9
 * Original Project CompoundedRecyclerView
 */
class BannerAdapterDelegate(val data: ArrayList<HomeModel>, val eventHandler: EventHandling) : SectionAdapterImp() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        return BannerViewHolder(createView(parent, R.layout.section_banner))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        val bannerData = data[position]
        if (bannerData is BannerModel) {
            (holder as BannerViewHolder).refreshData(bannerData.data)
        }
    }
}

class BannerViewHolder(rootView : View) : BaseViewHolder(rootView){

    private val selIndicatorWidth = 30f
    private val unselIndicatorWidth = 15f
    private val defaultIndicatedPos = 1

    private val viewPager:ViewPager
    private val indicator:RadioGroup

    private val viewList = ArrayList<View>()
    private val dataList = ArrayList<BannerItemModel>()

    private val layoutParams = RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT,RadioGroup.LayoutParams.WRAP_CONTENT)

    init {
        viewPager = rootView.findViewById(R.id.view_pager)
        indicator = rootView.findViewById(R.id.layout_indicator)

        initViewPager(viewPager)
        initIndicator(indicator)
    }

    private fun initIndicator(indicator:RadioGroup){
        indicator.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if(group == null)
                return@OnCheckedChangeListener

            for (i in 0 until group.childCount) {
                val child = group.getChildAt(i) as RadioButton
                val selWidth = if (child.id == checkedId) {
                    selIndicatorWidth
                } else {
                    unselIndicatorWidth
                }
                child.width  = dp2px(group.context, selWidth)
            }
        })
    }

    private fun initViewPager(viewPager:ViewPager){
        viewPager.adapter = HeadBannerAdapter(viewList, dataList)
        viewPager.setPageTransformer(true, BannerPageTransformer())

        viewPager.setOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(position: Int) {
                indicator.check(position + 1)
            }
        })
    }

    fun refreshData(data:ArrayList<BannerItemModel>){
        viewList.addAll(ViewListInflateDelegate<ImageView>(viewPager.context, R.layout.item_banner, Math.abs(data.size - dataList.size)).inflateStub())

        dataList.clear()
        dataList.addAll(data)

        viewPager.adapter.notifyDataSetChanged()

        updateIndicator(indicator)
    }

    private fun updateIndicator(indicator:RadioGroup){

        with(dp2px(indicator.context,2f)){
            layoutParams.setMargins(this,0,this,0)
        }

        for(item in ViewListInflateDelegate<RadioButton>(indicator.context, R.layout.item_banner_indicator, Math.abs(indicator.childCount - dataList.size)).inflateStub()) {

            indicator.addView(item,layoutParams)
        }

        if (indicator.checkedRadioButtonId == -1) {
            indicator.check(defaultIndicatedPos)
        }
    }
}

class HeadBannerAdapter(val views:ArrayList<View>, private val data:ArrayList<BannerItemModel>) : PagerAdapter() {

    override fun isViewFromObject(p0: View?, p1: Any?): Boolean {
        return p0 == p1
    }

    override fun getCount(): Int {
        return views.size
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val childView = views[position] as ImageView

        if (data.size > position) {
            childView.setImageResource(data[position].picRes)
        }

        container?.addView(childView)

        return childView
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container?.removeView(views[position])
    }
}

class ViewListInflateDelegate<T:View>(val context: Context, private val resId:Int, private val count:Int) {

    private val viewList = ArrayList<View>()

    fun inflateStub(): ArrayList<View> {

        val inflater = LayoutInflater.from(context)

        for (i in 0 until count) {
            try {
                val view : T = inflater.inflate(resId, null) as T
                viewList.add(view)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return viewList
    }
}

class BannerPageTransformer: ViewPager.PageTransformer{

    private var offsetHeight :Float = Float.MIN_VALUE
    private val maxOffsetHeight  = 20f

    private var offsetTranslationX : Float = Float.MIN_VALUE
    private val maxOffsetTranslationX  = 15f

    override fun transformPage(view: View?, position: Float) {

        if (position in -1..1) {
            view!!.pivotX = (view.width / 2).toFloat()
            view.pivotY = view.height.toFloat()
            view.scaleY = 1 - getOffsetHeight(view.context) * Math.abs(position) / view.height
            view.scaleX = 1 - getOffsetWidth(view.context, view) * Math.abs(position) / view.width
            view.translationX = getOffsetTranslationX(view.context) * (- position)
        }
    }

    private fun getOffsetTranslationX(context: Context):Float{
        if(offsetTranslationX ==Float.MIN_VALUE){
            offsetTranslationX = dp2px(context,maxOffsetTranslationX).toFloat()
        }
        return offsetTranslationX
    }

    private fun getOffsetWidth(context: Context, view: View): Float {
        val ratio: Float = getOffsetHeight(context) / view.height
        return view.width * ratio
    }

    private fun getOffsetHeight(context: Context):Float{
        if(offsetHeight == Float.MIN_VALUE) {
            offsetHeight = dp2px(context, maxOffsetHeight).toFloat()
        }
        return offsetHeight
    }

}