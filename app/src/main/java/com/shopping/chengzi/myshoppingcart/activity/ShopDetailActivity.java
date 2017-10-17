package com.shopping.chengzi.myshoppingcart.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.adapter.FragmentAdapter;
import com.shopping.chengzi.myshoppingcart.fragment.order.AllOrderFragment;
import com.shopping.chengzi.myshoppingcart.fragment.order.AlreadyPaymentFragment;
import com.shopping.chengzi.myshoppingcart.fragment.order.WaitPaymentFragment;
import com.shopping.chengzi.myshoppingcart.fragment.order.WaitReceiveGoodsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 店铺详情
 */
public class ShopDetailActivity extends FragmentActivity {


    @BindView(R.id.tv_order_all)
    TextView tvOrderAll;
    @BindView(R.id.tv_all_order_red_line)
    TextView tvAllOrderRedLine;
    @BindView(R.id.tv_order_wait_payment)
    TextView tvOrderWaitPayment;
    @BindView(R.id.tv_order_wait_payment_red_line)
    TextView tvOrderWaitPaymentRedLine;

    @BindView(R.id.tv_order_already_payment)
    TextView tvOrderAlreadyPayment;
    @BindView(R.id.rl_real_order_already_payment_red_line)
    TextView rlRealOrderAlreadyPaymentRedLine;
    @BindView(R.id.tv_shop_dong_tai)
    TextView tvShopDongTai;
    @BindView(R.id.rl_shop_dong_tai_line)
    TextView rlShopDongTaiLine;


    private ViewPager mViewPager;
    private FragmentAdapter mAdapter;
    private List<Fragment> fragments = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        ButterKnife.bind(this);
        initView();
        mViewPager = (ViewPager) findViewById(R.id.id_stickynavlayout_viewpager);
        /**
         * 初始化Adapter
         */
        mAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(mAdapter);
        resetTextView();

        mViewPager.setCurrentItem(0);
        tvOrderAll.setTextColor(getResources().getColor(R.color.background_tint_red));
        tvAllOrderRedLine.setBackgroundColor(getResources().getColor(R.color.background_tint_red));

        mViewPager.setOnPageChangeListener(new TabOnPageChangeListener());
    }

    private void initView() {

        tvOrderAll.setOnClickListener(new TabOnClickListener(0));
        tvOrderWaitPayment.setOnClickListener(new TabOnClickListener(1));
        tvOrderAlreadyPayment.setOnClickListener(new TabOnClickListener(2));
        tvShopDongTai.setOnClickListener(new TabOnClickListener(3));

        fragments.add(new AllOrderFragment());
        fragments.add(new AlreadyPaymentFragment());
        fragments.add(new WaitPaymentFragment());
        fragments.add(new WaitReceiveGoodsFragment());
    }

    /**
     * 重置颜色
     */
    private void resetTextView() {
        tvOrderAll.setTextColor(getResources().getColor(R.color.text_gray));
        tvOrderWaitPayment.setTextColor(getResources().getColor(R.color.text_gray));
        tvOrderAlreadyPayment.setTextColor(getResources().getColor(R.color.text_gray));
        tvShopDongTai.setTextColor(getResources().getColor(R.color.text_gray));

        tvAllOrderRedLine.setBackgroundColor(getResources().getColor(R.color.background_tint));
        tvOrderWaitPaymentRedLine.setBackgroundColor(getResources().getColor(R.color.background_tint));
        rlRealOrderAlreadyPaymentRedLine.setBackgroundColor(getResources().getColor(R.color.background_tint));
        rlShopDongTaiLine.setBackgroundColor(getResources().getColor(R.color.background_tint));
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
                    tvOrderAll.setTextColor(getResources().getColor(R.color.background_tint_red));
                    tvAllOrderRedLine.setBackgroundColor(getResources().getColor(R.color.background_tint_red));
                    break;
                case 1:
                    tvOrderWaitPayment.setTextColor(getResources().getColor(R.color.background_tint_red));
                    tvOrderWaitPaymentRedLine.setBackgroundColor(getResources().getColor(R.color.background_tint_red));
                    break;
                case 2:
                    tvOrderAlreadyPayment.setTextColor(getResources().getColor(R.color.background_tint_red));
                    rlRealOrderAlreadyPaymentRedLine.setBackgroundColor(getResources().getColor(R.color.background_tint_red));
                    break;
                case 3:
                    tvShopDongTai.setTextColor(getResources().getColor(R.color.background_tint_red));
                    rlShopDongTaiLine.setBackgroundColor(getResources().getColor(R.color.background_tint_red));
                    break;
            }
        }
    }
}
