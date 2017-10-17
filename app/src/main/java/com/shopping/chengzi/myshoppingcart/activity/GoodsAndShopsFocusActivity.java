package com.shopping.chengzi.myshoppingcart.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.adapter.FragmentAdapter;
import com.shopping.chengzi.myshoppingcart.fragment.GoodsFoucsFragment;
import com.shopping.chengzi.myshoppingcart.fragment.ShopFocusFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品和店铺收藏列表
 */
public class GoodsAndShopsFocusActivity extends AppCompatActivity {

    @BindView(R.id.tv_goods_focus)
    TextView goodsFocus;
    @BindView(R.id.tv_shop_focus)
    TextView shopFocus;
    @BindView(R.id.tv_goods_focus_view)
    TextView goodsFocusView;
    @BindView(R.id.tv_shop_focus_view)
    TextView shopFocusView;
    @BindView(R.id.iv_focus_back)
    ImageView back;

    private ViewPager mViewPager;
    private FragmentAdapter mAdapter;
    private List<Fragment> fragments = new ArrayList<Fragment>();

    String GoodsFocus;
    String ShopFocus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_and_shops_focus);
        ButterKnife.bind(this);
        initView();
        mViewPager = (ViewPager) findViewById(R.id.goods_focus_viewpager);
        /**
         * 初始化Adapter
         */
        mAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new TabOnPageChangeListener());
        loadActivity(this);
    }

    private void loadActivity(GoodsAndShopsFocusActivity goodsAndShopsFocusActivity) {
        Intent intent = getIntent();
        GoodsFocus = intent.getStringExtra("GOODS_FOCUS");
        ShopFocus = intent.getStringExtra("SHOP_FOCUS");

        if (GoodsFocus.equals("GOODS_FOCUS")) {
            mViewPager.setCurrentItem(0);
        } else {
            mViewPager.setCurrentItem(1);
        }
    }

    private void initView() {

        goodsFocus.setOnClickListener(new TabOnClickListener(0));
        shopFocus.setOnClickListener(new TabOnClickListener(1));

        fragments.add(new GoodsFoucsFragment());
        fragments.add(new ShopFocusFragment());
    }

    @OnClick(R.id.iv_focus_back)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_focus_back:
                finish();
                break;
        }
    }

    /**
     * 重置颜色
     */
    private void resetTextView() {
        goodsFocus.setTextColor(getResources().getColor(R.color.text));
        shopFocus.setTextColor(getResources().getColor(R.color.text));
    }


    /**
     * 功能：点击主页TAB事件
     */
    public class TabOnClickListener implements View.OnClickListener {
        private int index = 0;

        public TabOnClickListener(int i) {
            index = i;
        }

        public void onClick(View v) {
            mViewPager.setCurrentItem(index);//选择某一页
        }

    }

    /**
     * 功能：Fragment页面改变事件
     */
    public class TabOnPageChangeListener implements ViewPager.OnPageChangeListener {

        //当滑动状态改变时调用
        public void onPageScrollStateChanged(int state) {

        }

        //当前页面被滑动时调用
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //当新的页面被选中时调用
        public void onPageSelected(int position) {
            //重置所有TextView的字体颜色
            resetTextView();
            switch (position) {
                case 0:
                    goodsFocusView.setBackgroundResource(R.color.background_red);
                    shopFocusView.setBackgroundResource(R.color.white);
                    goodsFocus.setTextColor(getResources().getColor(R.color.background_red));
                    break;
                case 1:
                    goodsFocusView.setBackgroundResource(R.color.white);
                    shopFocusView.setBackgroundResource(R.color.background_red);
                    shopFocus.setTextColor(getResources().getColor(R.color.background_red));
                    break;
            }
        }
    }
}
