package com.shopping.chengzi.myshoppingcart.fragment.goods_detail;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.gxz.PagerSlidingTabStrip;
import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.activity.GoodsDetailActivity;
import com.shopping.chengzi.myshoppingcart.activity.ShopDetailActivity;
import com.shopping.chengzi.myshoppingcart.bean.BeanGoodsDetail;
import com.shopping.chengzi.myshoppingcart.utils.GlideImageLoader;
import com.shopping.chengzi.myshoppingcart.utils.LogUtil;
import com.shopping.chengzi.myshoppingcart.utils.Url;
import com.shopping.chengzi.myshoppingcart.widget.SlideDetailsLayout;
import com.squareup.okhttp.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * item页ViewPager里的商品Fragment
 */
public class GoodsInfoFragment extends Fragment implements View.OnClickListener, SlideDetailsLayout.OnSlideDetailsListener, OnBannerListener {

    private PagerSlidingTabStrip psts_tabs;
    private SlideDetailsLayout sv_switch;
    private ScrollView sv_goods_info;
    private FloatingActionButton fab_up_slide;

    private LinearLayout ll_goods_detail, ll_goods_config,llEnterShop;
    private TextView tv_goods_detail, tv_goods_config;
    public FrameLayout fl_content;
    private LinearLayout ll_pull_up;

    /**
     * 当前商品详情数据页的索引分别是图文详情、规格参数
     */
    public GoodsConfigFragment goodsConfigFragment;
    public GoodsInfoWebFragment goodsInfoWebFragment;
    private Fragment nowFragment;
    private List<TextView> tabTextList;
    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    public GoodsDetailActivity activity;


    /**
     * 商品详情页顶部图片
     */
    ImageView imageView;//轮播图
    List<String> imgs = new ArrayList<>();
    List<View> bannerViewList = new ArrayList<>();
    // 装ImageView数组
    private ImageView[] mImageViews;
    // 图片资源id
    private String[] strPic;

    /**
     * 商品详情数据集合
     */
    private List<BeanGoodsDetail.DatasBean> goodsList = new ArrayList<>();

    private String goodsId;//商品id

    private View waitLayout;//进度条

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (GoodsDetailActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goods_info, container, false);
        initView(view);
        initListener();
        initData();
        loadData();//加载商品详情数据
        return view;
    }

    private void initView(View rootView) {

        goodsId = getActivity().getIntent().getStringExtra(Url.GOODS_ID);//拿到goodsid识别商品

        waitLayout = rootView.findViewById(R.id.wait_layout);
        waitLayout.setVisibility(View.VISIBLE);

        psts_tabs = (PagerSlidingTabStrip) rootView.findViewById(R.id.psts_tabs);
        fab_up_slide = (FloatingActionButton) rootView.findViewById(R.id.fab_up_slide);
        sv_switch = (SlideDetailsLayout) rootView.findViewById(R.id.sv_switch);
        sv_goods_info = (ScrollView) rootView.findViewById(R.id.sv_goods_info);
        fl_content = (FrameLayout) rootView.findViewById(R.id.fl_content);
        ll_pull_up = (LinearLayout) rootView.findViewById(R.id.ll_pull_up);
        ll_goods_detail = (LinearLayout) rootView.findViewById(R.id.ll_goods_detail);
        ll_goods_config = (LinearLayout) rootView.findViewById(R.id.ll_goods_config);
        tv_goods_detail = (TextView) rootView.findViewById(R.id.tv_goods_detail);
        tv_goods_config = (TextView) rootView.findViewById(R.id.tv_goods_config);

        llEnterShop= (LinearLayout) rootView.findViewById(R.id.ll_enter_store);
        llEnterShop.setOnClickListener(this);
        setDetailData();
        fab_up_slide.hide();
    }

    /**
     * 加载商品详情数据
     */
    private void loadData() {
        OkHttpUtils.post().url(Url.HOST + Url.GOODS_DETAILS).tag(this)
                .addParams(Url.GOODS_ID, goodsId)
                .build().execute(new GoodsDetailCallBack());
        Log.i("商品id==", goodsId);
    }

    @Override
    public void OnBannerClick(int position) {
        Intent intent = new Intent(getActivity(), GoodsDetailsBigPic.class);
        intent.putExtra("bigpic", strPic);
        startActivity(intent);
    }

    private class GoodsDetailCallBack extends StringCallback {
        @Override
        public void onError(Request request, Exception e) {
            waitLayout.setVisibility(View.GONE);
        }

        @Override
        public void onResponse(String response) {
            addData(response.toString());
            LogUtil.i("详情数据" + response.toString());
            waitLayout.setVisibility(View.GONE);
        }

        private void addData(String s) {
            BeanGoodsDetail beanGoodsDetail = JSON.parseObject(s, BeanGoodsDetail.class);
            //banner图
            String morePic = beanGoodsDetail.getDatas().getGoods_image();


            strPic = morePic.split(",");
            //将图片装载到数组中
            mImageViews = new ImageView[strPic.length];
            initBanner();
            for (int i = 0; i < mImageViews.length; i++) {
                Glide.with(getActivity()).load(strPic[i]).into(imageView);
                imgs.add(strPic[i]);
                LogUtil.i("图片资源" + imgs);
            }
            BannerImageLoad(getView());
        }
    }

    /**
     * 初始化接受轮播图片的控件
     */
    private void initBanner() {
        for (int i = 0; i < strPic.length; i++) {
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
        Banner banner = (Banner) view.findViewById(R.id.godds_detail_banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        //设置图片加载器
        banner.setImages(imgs).setImageLoader(new GlideImageLoader()).setOnBannerListener(this);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(false);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.NUM_INDICATOR);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }


    private void initListener() {
        fab_up_slide.setOnClickListener(this);
        ll_pull_up.setOnClickListener(this);
        ll_goods_detail.setOnClickListener(this);
        ll_goods_config.setOnClickListener(this);
        sv_switch.setOnSlideDetailsListener(this);
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        tabTextList = new ArrayList<>();
        tabTextList.add(tv_goods_detail);
        tabTextList.add(tv_goods_config);
    }

    /**
     * 加载完商品详情执行
     */
    public void setDetailData() {
        goodsConfigFragment = new GoodsConfigFragment();
        goodsInfoWebFragment = new GoodsInfoWebFragment();
        fragmentList.add(goodsConfigFragment);
        fragmentList.add(goodsInfoWebFragment);

        nowFragment = goodsInfoWebFragment;
        fragmentManager = getChildFragmentManager();
        //默认显示商品详情tab
        fragmentManager.beginTransaction().replace(R.id.fl_content, nowFragment).commitAllowingStateLoss();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_pull_up:
                //上拉查看图文详情
                sv_switch.smoothOpen(true);
                break;

            case R.id.fab_up_slide:
                //点击滑动到顶部
                sv_goods_info.smoothScrollTo(0, 0);
                sv_switch.smoothClose(true);
                break;

            case R.id.ll_goods_detail:
                tv_goods_detail.setTextColor(getResources().getColor(R.color.background_red));
                tv_goods_config.setTextColor(getResources().getColor(R.color.text));
                //商品详情tab
                switchFragment(nowFragment, goodsInfoWebFragment);
                nowFragment = goodsInfoWebFragment;
                break;

            case R.id.ll_goods_config:
                tv_goods_config.setTextColor(getResources().getColor(R.color.background_red));
                tv_goods_detail.setTextColor(getResources().getColor(R.color.text));
                //规格参数tab
                switchFragment(nowFragment, goodsConfigFragment);
                nowFragment = goodsConfigFragment;
                break;

            case R.id.ll_enter_store:
               startActivity(new Intent(getActivity(),ShopDetailActivity.class));
                break;

            default:
                break;
        }
    }

    @Override
    public void onStatucChanged(SlideDetailsLayout.Status status) {
        if (status == SlideDetailsLayout.Status.OPEN) {
            //当前为图文详情页
            fab_up_slide.show();
            activity.vp_content.setNoScroll(true);
            activity.tv_title.setVisibility(View.VISIBLE);
            activity.psts_tabs.setVisibility(View.GONE);
        } else {
            //当前为商品详情页
            fab_up_slide.hide();
            activity.vp_content.setNoScroll(false);
            activity.tv_title.setVisibility(View.GONE);
            activity.psts_tabs.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 切换Fragment
     * <p>(hide、show、add)
     *
     * @param fromFragment
     * @param toFragment
     */
    private void switchFragment(Fragment fromFragment, Fragment toFragment) {
        if (nowFragment != toFragment) {
            fragmentTransaction = fragmentManager.beginTransaction();
            if (!toFragment.isAdded()) {    // 先判断是否被add过
                fragmentTransaction.hide(fromFragment).add(R.id.fl_content, toFragment).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到activity中
            } else {
                fragmentTransaction.hide(fromFragment).show(toFragment).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
        }
    }

}
