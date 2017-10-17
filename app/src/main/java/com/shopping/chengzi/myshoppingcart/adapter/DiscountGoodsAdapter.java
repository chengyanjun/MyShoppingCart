package com.shopping.chengzi.myshoppingcart.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.activity.GoodsDetailActivity;
import com.shopping.chengzi.myshoppingcart.bean.BeanHome;
import com.shopping.chengzi.myshoppingcart.utils.Url;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengzi on 2017/3/17.
 */

public class DiscountGoodsAdapter extends RecyclerView.Adapter<DiscountGoodsAdapter.DiscountGoodsViewHolder> {

    private List<BeanHome.DatasBean.GoodsBean.ItemBeanX> list = new ArrayList<>();
    private Context context;

    public DiscountGoodsAdapter(List<BeanHome.DatasBean.GoodsBean.ItemBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public DiscountGoodsAdapter.DiscountGoodsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_discount_goods, parent, false);
        DiscountGoodsViewHolder holder = new DiscountGoodsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DiscountGoodsAdapter.DiscountGoodsViewHolder holder, final int position) {
        BeanHome.DatasBean.GoodsBean.ItemBeanX beanX = list.get(position);
        if (beanX != null) {
            holder.discountPrice.setText(beanX.getGoods_marketprice());
            holder.marketPrice.setText("￥" + beanX.getGoods_price());
            holder.marketPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);//设置中划线
            ImageLoader.getInstance().displayImage(beanX.getGoods_image(), holder.discountGoods);

            holder.goodsPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, GoodsDetailActivity.class);
                    intent.putExtra(Url.GOODS_ID, list.get(position).getGoods_id());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DiscountGoodsViewHolder extends RecyclerView.ViewHolder {

        ImageView discountGoods;
        TextView discountPrice;//折扣价
        TextView marketPrice;//市场价
        LinearLayout goodsPic;//点击跳转事件

        public DiscountGoodsViewHolder(View itemView) {
            super(itemView);
            discountGoods = (ImageView) itemView.findViewById(R.id.iv_discount_goods);
            discountPrice = (TextView) itemView.findViewById(R.id.tv_discount_price);
            marketPrice = (TextView) itemView.findViewById(R.id.tv_market_price);
            goodsPic = (LinearLayout) itemView.findViewById(R.id.ll_limit_time_goods_pic);

        }
    }
}
