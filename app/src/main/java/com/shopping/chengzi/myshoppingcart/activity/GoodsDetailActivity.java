package com.shopping.chengzi.myshoppingcart.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gxz.PagerSlidingTabStrip;
import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.adapter.ItemTitlePagerAdapter;
import com.shopping.chengzi.myshoppingcart.fragment.goods_detail.GoodsCommentFragment;
import com.shopping.chengzi.myshoppingcart.fragment.goods_detail.GoodsDetailFragment;
import com.shopping.chengzi.myshoppingcart.fragment.goods_detail.GoodsInfoFragment;
import com.shopping.chengzi.myshoppingcart.utils.ToastUtil;
import com.shopping.chengzi.myshoppingcart.widget.NoScrollViewPager;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品详情
 */
public class GoodsDetailActivity extends AppCompatActivity {
    public PagerSlidingTabStrip psts_tabs;
    public NoScrollViewPager vp_content;
    public TextView tv_title;

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_goods_detail_more)
    ImageView ivGoodsDetailMore;
    @BindView(R.id.ll_goods_detail_enter_shop)
    AutoLinearLayout llGoodsDetailEnterShop;
    @BindView(R.id.iv_goods_collect)
    ImageView ivGoodsCollect;
    @BindView(R.id.iv_goods_collect_text)
    TextView ivGoodsCollectText;
    @BindView(R.id.ll_goods_detail_collect_goods)
    AutoLinearLayout llGoodsDetailCollectGoods;
    @BindView(R.id.shopping_cart_num)
    TextView shoppingCartNum;
    @BindView(R.id.ll_goods_detail_shopping_cart)
    AutoLinearLayout llGoodsDetailShoppingCart;
    @BindView(R.id.iv_goods_add_shopping_cart)
    TextView ivGoodsAddShoppingCart;
    private LinearLayout back;

    private List<Fragment> fragmentList = new ArrayList<>();
    private GoodsInfoFragment goodsInfoFragment;
    private GoodsDetailFragment goodsDetailFragment;
    private GoodsCommentFragment goodsCommentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);

        psts_tabs = (PagerSlidingTabStrip) findViewById(R.id.psts_tabs);
        vp_content = (NoScrollViewPager) findViewById(R.id.vp_content);
        tv_title = (TextView) findViewById(R.id.tv_title);

        fragmentList.add(goodsInfoFragment = new GoodsInfoFragment());
        fragmentList.add(goodsDetailFragment = new GoodsDetailFragment());
        fragmentList.add(goodsCommentFragment = new GoodsCommentFragment());
        vp_content.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(),
                fragmentList, new String[]{"商品", "详情", "评价"}));
        vp_content.setOffscreenPageLimit(3);
        psts_tabs.setViewPager(vp_content);
    }

    @OnClick({R.id.iv_back, R.id.iv_goods_detail_more, R.id.ll_goods_detail_enter_shop, R.id.ll_goods_detail_collect_goods, R.id.ll_goods_detail_shopping_cart, R.id.iv_goods_add_shopping_cart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_goods_detail_more:
                ToastUtil.showShort(this,"待实现");
                break;
            case R.id.ll_goods_detail_enter_shop:
                startActivity(new Intent(this,ShopDetailActivity.class));
                break;
            case R.id.ll_goods_detail_collect_goods:
                ToastUtil.showShort(this,"待实现");
                break;
            case R.id.ll_goods_detail_shopping_cart:
                ToastUtil.showShort(this,"待实现");
                break;
            case R.id.iv_goods_add_shopping_cart:
                ToastUtil.showShort(this,"待实现");
                break;
        }
    }
}
