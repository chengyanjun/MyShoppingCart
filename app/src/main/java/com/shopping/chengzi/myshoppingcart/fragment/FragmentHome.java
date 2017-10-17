package com.shopping.chengzi.myshoppingcart.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.shopping.chengzi.myshoppingcart.MainActivity;
import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.activity.GoodsAndShopsFocusActivity;
import com.shopping.chengzi.myshoppingcart.activity.user_info.LoginActivity;
import com.shopping.chengzi.myshoppingcart.activity.user_info.SettingActivity;
import com.shopping.chengzi.myshoppingcart.adapter.DiscountGoodsAdapter;
import com.shopping.chengzi.myshoppingcart.adapter.HomeGoodsClassifyGridViewAdapter;
import com.shopping.chengzi.myshoppingcart.adapter.HomeGoodsListGridViewAdapter;
import com.shopping.chengzi.myshoppingcart.bean.BeanHome;
import com.shopping.chengzi.myshoppingcart.bean.BeanHomeGoodsList;
import com.shopping.chengzi.myshoppingcart.utils.GlideImageLoader;
import com.shopping.chengzi.myshoppingcart.utils.LogUtil;
import com.shopping.chengzi.myshoppingcart.utils.ToastUtil;
import com.shopping.chengzi.myshoppingcart.utils.Url;
import com.shopping.chengzi.myshoppingcart.widget.GridViewInScrollView;
import com.shopping.chengzi.myshoppingcart.widget.countdowntimer.MainDownTimerView;
import com.shopping.chengzi.myshoppingcart.widget.countdowntimer.OnCountDownTimerListener;
import com.squareup.okhttp.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * app首页
 */
public class FragmentHome extends Fragment implements OnBannerListener {

    // 拥有一个公开的TAG
    public static final String TAG = FragmentHome.class.getSimpleName();

    ImageView imageView;//轮播图
    List<String> imgs = new ArrayList<>();
    List<View> bannerViewList = new ArrayList<>();
    List<BeanHome.DatasBean.AdvListBean.ItemBean> banList;

    //首页两排按钮
    @BindView(R.id.rl_home_item1)
    RelativeLayout item1;
    @BindView(R.id.rl_home_item2)
    RelativeLayout item2;
    @BindView(R.id.rl_home_item3)
    RelativeLayout item3;
    @BindView(R.id.rl_home_item4)
    RelativeLayout item4;
    @BindView(R.id.rl_home_item5)
    RelativeLayout item5;
    @BindView(R.id.rl_home_item6)
    RelativeLayout item6;
    @BindView(R.id.rl_home_item7)
    RelativeLayout item7;
    @BindView(R.id.rl_home_item8)
    RelativeLayout item8;


    private MainDownTimerView tvTimeDiscount;//倒计时

    //限时折扣
    private RecyclerView rvDiscountGoods;
    private TextView moreGoods;//更多
    private DiscountGoodsAdapter discountGoodsAdapter;
    private List<BeanHome.DatasBean.GoodsBean.ItemBeanX> discountGoodsList = new ArrayList<>();

    //首页商品分类展示
    private HomeGoodsClassifyGridViewAdapter homeGoodsClassifyGridViewAdapter;
    private List<BeanHome.DatasBean.Home3Bean.ItemBeanXX> home3Been = new ArrayList<>();
    private GridViewInScrollView gvHomeGoodsClassify;//grid view

    //首页底部商品展示
    private HomeGoodsListGridViewAdapter homeGoodsListGridViewAdapter;//我的界面的商品推荐grid view适配器
    private List<BeanHomeGoodsList.DatasBean.GoodsListBean> list = new ArrayList<>();
    private GridViewInScrollView gridViewInScrollView;//grid view

    String key;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        InitView(view);
        initEvent();
        startDownTimer();
        InitHomeData();
        InitAdData(view);//初始化首页广告轮播图
        InitHomeGoodsList();

        return view;
    }

    private void InitView(View view) {

        tvTimeDiscount = (MainDownTimerView) view.findViewById(R.id.tv_time_account);
        tvTimeDiscount.setDownTime(16000000);

        rvDiscountGoods = (RecyclerView) view.findViewById(R.id.rv_discount_goods);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvDiscountGoods.setLayoutManager(linearLayoutManager);

        gridViewInScrollView = (GridViewInScrollView) view.findViewById(R.id.gv_home_goods_list);
        gvHomeGoodsClassify = (GridViewInScrollView) view.findViewById(R.id.gv_home_goods_classify);
    }

    /**
     * 首页顶部按钮
     *
     * @param view
     */
    @OnClick({R.id.rl_home_item1, R.id.rl_home_item2, R.id.rl_home_item3, R.id.rl_home_item4, R.id.rl_home_item5, R.id.rl_home_item6, R.id.rl_home_item7, R.id.rl_home_item8})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_home_item1:
                if ("".equals(key)) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    Intent intent = new Intent(getActivity(), GoodsAndShopsFocusActivity.class);
                    intent.putExtra("GOODS_FOCUS", "GOODS_FOCUS");
                    intent.putExtra("SHOP_FOCUS", "0");
                    startActivity(intent);
                }
                break;
            case R.id.rl_home_item2:
                if ("".equals(key)) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    Intent intent2 = new Intent(getActivity(), GoodsAndShopsFocusActivity.class);
                    intent2.putExtra("GOODS_FOCUS", "0");
                    intent2.putExtra("SHOP_FOCUS", "SHOP_FOCUS");
                    startActivity(intent2);
                }
                break;
            case R.id.rl_home_item3:
                if ("".equals(key)) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), SettingActivity.class));
                }
                break;
            case R.id.rl_home_item4:
//                if ("".equals(key)) {
//                    startActivity(new Intent(getActivity(), LoginActivity.class));
//                } else {
//                    startActivity(new Intent(getActivity(), SettingActivity.class));
//                }

                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.switchPage(FragmentClassify.TAG, FragmentClassify.class);



                break;
            case R.id.rl_home_item5:
                if ("".equals(key)) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), SettingActivity.class));
                }
                break;
            case R.id.rl_home_item6:
                if ("".equals(key)) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), SettingActivity.class));
                }
                break;
            case R.id.rl_home_item7:
                if ("".equals(key)) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), SettingActivity.class));
                }
                break;
            case R.id.rl_home_item8:
                if ("".equals(key)) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), SettingActivity.class));
                }
                break;

        }
    }

    private void initEvent() {
        tvTimeDiscount.setDownTimerListener(new OnCountDownTimerListener() {

            @Override
            public void onFinish() {
                Toast.makeText(getActivity(), "活动结束", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void startDownTimer() {
        tvTimeDiscount.startDownTimer();
    }


    /**
     * 初始化首页广告轮播图
     */
    private void InitAdData(View view) {
        //首页垂直广告轮播图
        ViewFlipper vf = (ViewFlipper) view.findViewById(R.id.vf);
        vf.addView(View.inflate(getActivity(), R.layout.view_advertisement01, null));
        vf.addView(View.inflate(getActivity(), R.layout.view_advertisement02, null));
        vf.addView(View.inflate(getActivity(), R.layout.view_advertisement03, null));

    }

    /**
     * 获取首页数据
     */
    private void InitHomeData() {
        LogUtil.i("============");
        OkHttpUtils.post().url(Url.HOST + Url.HOME_DATA)
                .addParams("", "")
                .build().execute(new HomeCallBack());
    }

    /**
     * 获取首页展示商品数据
     */
    private void InitHomeGoodsList() {
        OkHttpUtils.post().url(Url.HOST + Url.HOME_GOODS_LIST)
                .addParams("", "")
                .build().execute(new HomeGoodsListCallBack());

    }

    @Override
    public void OnBannerClick(int position) {
        switch (position) {
            case 0:
                ToastUtil.showShort(getActivity(), "点我吧");
                break;
            case 1:
                ToastUtil.showShort(getActivity(), "点我了吗");
                break;
        }
    }

    private class HomeCallBack extends StringCallback {
        @Override
        public void onError(Request request, Exception e) {
        }

        @Override
        public void onResponse(String response) {
            addData(response.toString());
        }
    }

    /**
     * 获取首页数据
     *
     * @param s
     */
    private void addData(String s) {
        BeanHome beanHome = JSON.parseObject(s, BeanHome.class);
        //banner图
        banList = beanHome.getDatas().get(0).getAdv_list().getItem();
        initBanner();
        for (int i = 0; i < banList.size(); i++) {
            Glide.with(getActivity()).load(banList.get(i).getImage()).into(imageView);
            imgs.add(banList.get(i).getImage());
        }
        BannerImageLoad(getView());

        //限时折扣
        discountGoodsList = beanHome.getDatas().get(1).getGoods().getItem();
        discountGoodsAdapter = new DiscountGoodsAdapter(discountGoodsList, getActivity());
        rvDiscountGoods.setAdapter(discountGoodsAdapter);


        //首页商品分类展示
        home3Been = beanHome.getDatas().get(2).getHome3().getItem();
        homeGoodsClassifyGridViewAdapter = new HomeGoodsClassifyGridViewAdapter(home3Been, getActivity());
        gvHomeGoodsClassify.setAdapter(homeGoodsClassifyGridViewAdapter);


    }

    /**
     * 初始化接受轮播图片的控件
     */
    private void initBanner() {
        for (int i = 0; i < banList.size(); i++) {
            imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            bannerViewList.add(imageView);
        }
    }

    /**
     * 获取轮播图
     *
     * @param view
     */
    private void BannerImageLoad(View view) {
        Banner banner = (Banner) view.findViewById(R.id.home_banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImages(imgs).setImageLoader(new GlideImageLoader()).setOnBannerListener(this);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.NUM_INDICATOR);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    /**
     * 首页商品列表展示
     */
    private class HomeGoodsListCallBack extends StringCallback {
        @Override
        public void onError(Request request, Exception e) {
        }

        @Override
        public void onResponse(String response) {
            BeanHomeGoodsList beanHomeGoodsList = JSON.parseObject(response.toString(), BeanHomeGoodsList.class);
            list = beanHomeGoodsList.getDatas().getGoods_list();
            homeGoodsListGridViewAdapter = new HomeGoodsListGridViewAdapter(list, getActivity());
            gridViewInScrollView.setAdapter(homeGoodsListGridViewAdapter);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        key = Url.getKey(getActivity());//获取key值
    }
}
