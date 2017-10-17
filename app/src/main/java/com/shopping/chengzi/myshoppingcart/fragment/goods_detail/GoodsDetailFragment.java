package com.shopping.chengzi.myshoppingcart.fragment.goods_detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shopping.chengzi.myshoppingcart.R;

import java.util.ArrayList;
import java.util.List;

/**
 * item页ViewPager里的商品详情Fragment
 */
public class GoodsDetailFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ll_goods_detail, ll_goods_config;
    private TextView tv_goods_detail, tv_goods_config;
    private FrameLayout fl_content;

    private List<TextView> tabTextList;
    private GoodsConfigFragment goodsConfigFragment;
    private GoodsDetailWebFragment goodsDetailWebFragment;
    private Fragment nowFragment;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goods_detail, container, false);
        initView(view);
        initListener();
        return view;
    }

    private void initListener() {
        ll_goods_detail.setOnClickListener(this);
        ll_goods_config.setOnClickListener(this);
    }

    private void initView(View view) {
        ll_goods_detail = (LinearLayout) view.findViewById(R.id.ll_goods_detail);
        ll_goods_config = (LinearLayout) view.findViewById(R.id.ll_goods_config);
        tv_goods_detail = (TextView) view.findViewById(R.id.tv_goods_detail);
        tv_goods_config = (TextView) view.findViewById(R.id.tv_goods_config);
        fl_content = (FrameLayout) view.findViewById(R.id.fl_content);

        tabTextList = new ArrayList<>();
        tabTextList.add(tv_goods_detail);
        tabTextList.add(tv_goods_config);
        setData();
    }

    /**
     * 商品信息Fragment页获取完数据执行
     */
    public void setData() {
        goodsConfigFragment = new GoodsConfigFragment();
        goodsDetailWebFragment = new GoodsDetailWebFragment();

        nowFragment = goodsDetailWebFragment;
        fragmentManager = getChildFragmentManager();
        //默认显示商品详情tab
        fragmentManager.beginTransaction().replace(R.id.fl_content, nowFragment).commitAllowingStateLoss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_goods_detail:
                tv_goods_detail.setTextColor(getResources().getColor(R.color.background_red));
                tv_goods_config.setTextColor(getResources().getColor(R.color.text));
                //商品详情tab
                switchFragment(nowFragment, goodsDetailWebFragment);
                nowFragment = goodsDetailWebFragment;
                break;

            case R.id.ll_goods_config:
                tv_goods_config.setTextColor(getResources().getColor(R.color.background_red));
                tv_goods_detail.setTextColor(getResources().getColor(R.color.text));
                //规格参数tab
                switchFragment(nowFragment, goodsConfigFragment);
                nowFragment = goodsConfigFragment;
                break;

            default:
                break;
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
