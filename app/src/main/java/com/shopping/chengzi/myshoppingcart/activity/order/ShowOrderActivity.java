package com.shopping.chengzi.myshoppingcart.activity.order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.adapter.FragmentAdapter;
import com.shopping.chengzi.myshoppingcart.fragment.order.AllOrderFragment;
import com.shopping.chengzi.myshoppingcart.fragment.order.AlreadyPaymentFragment;
import com.shopping.chengzi.myshoppingcart.fragment.order.WaitEvaluateFragment;
import com.shopping.chengzi.myshoppingcart.fragment.order.WaitPaymentFragment;
import com.shopping.chengzi.myshoppingcart.fragment.order.WaitReceiveGoodsFragment;
import com.shopping.chengzi.myshoppingcart.utils.InitTopBar;
import com.shopping.chengzi.myshoppingcart.utils.Url;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 展示订单的界面
 */
public class ShowOrderActivity extends AppCompatActivity {

    @BindView(R.id.tv_order_all)
    TextView tvAllOrder;
    @BindView(R.id.tv_order_wait_payment)
    TextView tvWaitPaymentOrder;
    @BindView(R.id.tv_order_already_payment)
    TextView tvAlreadyPayment;
    @BindView(R.id.tv_order_wait_receive)
    TextView tvWaitReceive;
    @BindView(R.id.tv_order_wait_evaluate)
    TextView tvWaitEvaluate;

    @BindView(R.id.tv_all_order_red_line)
    TextView allOrderView;
    @BindView(R.id.tv_order_wait_payment_red_line)
    TextView waitPaymentOrderView;
    @BindView(R.id.rl_real_order_already_payment_red_line)
    TextView alreadyPaymentView;
    @BindView(R.id.tv_order_wait_receive_red_line)
    TextView waitReceiveView;
    @BindView(R.id.tv_order_wait_evaluate_red_line)
    TextView waitEvaluateView;


    private ViewPager mViewPager;
    private FragmentAdapter mAdapter;
    private List<Fragment> fragments = new ArrayList<Fragment>();

    String allOrder;
    String waitPayment;
    String alreadyPayment;
    String waitReceive;
    String waitEvaluate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_order);
        ButterKnife.bind(this);
        InitTopBar.initiTopImg(this, "我的订单", R.mipmap.search);

        waitPayment = getIntent().getStringExtra(Url.WAIT_PAYMENT);
        alreadyPayment = getIntent().getStringExtra(Url.ALREADY_PAYMENT);
        waitReceive = getIntent().getStringExtra(Url.WAIT_RECEIVE);
        waitEvaluate =getIntent().getStringExtra(Url.WAIT_EVALUATE);
        allOrder = getIntent().getStringExtra(Url.ALL_ORDER);

        initView();

        mViewPager = (ViewPager) findViewById(R.id.real_order_viewpager);
        /**
         * 初始化Adapter
         */
        mAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(mAdapter);
        resetTextView();

        if (allOrder != null && allOrder.equals(Url.ALL_ORDER)) {
            mViewPager.setCurrentItem(0);
            tvAllOrder.setTextColor(getResources().getColor(R.color.background_red));
            allOrderView.setBackgroundColor(getResources().getColor(R.color.background_red));
        }
        if (waitPayment != null && waitPayment.equals(Url.WAIT_PAYMENT)) {
            mViewPager.setCurrentItem(1);
            tvWaitPaymentOrder.setTextColor(getResources().getColor(R.color.background_red));
            waitPaymentOrderView.setBackgroundColor(getResources().getColor(R.color.background_red));
        }
        if (alreadyPayment != null && alreadyPayment.equals(Url.ALREADY_PAYMENT)) {
            mViewPager.setCurrentItem(2);
            tvAlreadyPayment.setTextColor(getResources().getColor(R.color.background_red));
            alreadyPaymentView.setBackgroundColor(getResources().getColor(R.color.background_red));
        }
        if (waitReceive != null && waitReceive.equals(Url.WAIT_RECEIVE)) {
            mViewPager.setCurrentItem(3);
            tvWaitReceive.setTextColor(getResources().getColor(R.color.background_red));
            waitReceiveView.setBackgroundColor(getResources().getColor(R.color.background_red));
        }
        if (waitEvaluate != null && waitEvaluate.equals(Url.WAIT_EVALUATE)) {
            mViewPager.setCurrentItem(4);
            tvWaitEvaluate.setTextColor(getResources().getColor(R.color.background_red));
            waitEvaluateView.setBackgroundColor(getResources().getColor(R.color.background_red));
        }

        mViewPager.setOnPageChangeListener(new TabOnPageChangeListener());
    }

    private void initView() {

        tvAllOrder.setOnClickListener(new TabOnClickListener(0));
        tvWaitPaymentOrder.setOnClickListener(new TabOnClickListener(1));
        tvAlreadyPayment.setOnClickListener(new TabOnClickListener(2));
        tvWaitReceive.setOnClickListener(new TabOnClickListener(3));
        tvWaitEvaluate.setOnClickListener(new TabOnClickListener(4));

        fragments.add(new AllOrderFragment());
        fragments.add(new WaitPaymentFragment());
        fragments.add(new AlreadyPaymentFragment());
        fragments.add(new WaitReceiveGoodsFragment());
        fragments.add(new WaitEvaluateFragment());
    }

    /**
     * 重置颜色
     */
    private void resetTextView() {
        tvAllOrder.setTextColor(getResources().getColor(R.color.text));
        tvWaitPaymentOrder.setTextColor(getResources().getColor(R.color.text));
        tvAlreadyPayment.setTextColor(getResources().getColor(R.color.text));
        tvWaitReceive.setTextColor(getResources().getColor(R.color.text));
        tvWaitEvaluate.setTextColor(getResources().getColor(R.color.text));

        allOrderView.setBackgroundColor(getResources().getColor(R.color.white));
        waitPaymentOrderView.setBackgroundColor(getResources().getColor(R.color.white));
        alreadyPaymentView.setBackgroundColor(getResources().getColor(R.color.white));
        waitReceiveView.setBackgroundColor(getResources().getColor(R.color.white));
        waitEvaluateView.setBackgroundColor(getResources().getColor(R.color.white));
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
                    tvAllOrder.setTextColor(getResources().getColor(R.color.background_red));
                    allOrderView.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_shade));
                    break;
                case 1:
                    tvWaitPaymentOrder.setTextColor(getResources().getColor(R.color.background_red));
                    waitPaymentOrderView.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_shade));
                    break;
                case 2:
                    tvAlreadyPayment.setTextColor(getResources().getColor(R.color.background_red));
                    alreadyPaymentView.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_shade));
                    break;
                case 3:
                    tvWaitReceive.setTextColor(getResources().getColor(R.color.background_red));
                    waitReceiveView.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_shade));
                    break;
                case 4:
                    tvWaitEvaluate.setTextColor(getResources().getColor(R.color.background_red));
                    waitEvaluateView.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_shade));
                    break;
            }
        }
    }
}
