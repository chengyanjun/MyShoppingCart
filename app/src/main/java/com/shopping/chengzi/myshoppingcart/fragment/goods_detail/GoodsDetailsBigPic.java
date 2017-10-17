package com.shopping.chengzi.myshoppingcart.fragment.goods_detail;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shopping.chengzi.myshoppingcart.R;

/**
 * 商品详情大图展示
 */

public class GoodsDetailsBigPic extends AppCompatActivity implements ViewPager.OnPageChangeListener{


    private LinearLayout group;
    private ViewPager viewPager;
    private  ViewPagerAdapter viewPagerAdapter;
    // 装点点的ImageView数组
    private ImageView[] tips;
    // 装ImageView数组
    private ImageView[] mImageViews;
    // 图片资源id
    private String[] strPic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_details_big_pic);
        initView();
    }

    private void initView() {//加载商品信息
        group=(LinearLayout)this.findViewById(R.id.viewGroup);
        viewPager=(ViewPager)this.findViewById(R.id.viewPager_goods_pic);
        viewPagerAdapter=new ViewPagerAdapter();

        strPic=getIntent().getStringArrayExtra("bigpic");

        tips = new ImageView[strPic.length];
        for (int i = 0; i < tips.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(10, 10));
            tips[i] = imageView;
            if (i == 0) {
                tips[i].setBackgroundResource(R.mipmap.viewpager_red_circle);
            } else {
                tips[i].setBackgroundResource(R.mipmap.viewpager_grey_circle);
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin = 18;
            layoutParams.rightMargin = 5;
            group.addView(imageView, layoutParams);
        }

        //将图片装载到数组中
        mImageViews = new ImageView[strPic.length];
        for (int i = 0; i < mImageViews.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            mImageViews[i] = imageView;
            ImageLoader.getInstance().displayImage(strPic[i], imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GoodsDetailsBigPic.this.finish();
                }
            });
        }

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem(0);

    }

    //viewpager的adapter
    private class ViewPagerAdapter extends PagerAdapter {
        public ViewPagerAdapter(){
        }
        @Override
        public int getCount() {
            return strPic.length;
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager)container).removeView(mImageViews[position % mImageViews.length]);
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {  //这个方法用来实例化页卡
            container.addView(mImageViews[position % mImageViews.length], 0);//添加页卡
            return mImageViews[position % mImageViews.length];
        }
    }

    //viewpager滑动
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
    @Override
    public void onPageSelected(int position) {
        setImageBackground(position % mImageViews.length);
    }
    @Override
    public void onPageScrollStateChanged(int state) {
    }
    private void setImageBackground(int selectItems) {
        for (int i = 0; i < tips.length; i++) {
            if (i == selectItems) {
                tips[i].setBackgroundResource(R.mipmap.viewpager_red_circle);
            } else {
                tips[i].setBackgroundResource(R.mipmap.viewpager_grey_circle);
            }
        }
    }

}
