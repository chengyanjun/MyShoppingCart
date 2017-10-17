package com.shopping.chengzi.myshoppingcart.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.shopping.chengzi.myshoppingcart.bean.BeanGoodsFocus;
import com.shopping.chengzi.myshoppingcart.utils.Url;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by chengzi on 2017/3/31.
 */

public class AdapterGoodsFoucs extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<BeanGoodsFocus.DatasBean.FavoritesListBean> lists;

    public AdapterGoodsFoucs(Context context, List<BeanGoodsFocus.DatasBean.FavoritesListBean> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_focus_goods,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.setPosition(position);

        if (lists != null) {
            viewHolder.goodsName.setText(lists.get(position).getGoods_name());
            ImageLoader.getInstance().displayImage(lists.get(position).getGoods_image_url(), viewHolder.goodsPic);
            viewHolder.goodsPrice.setText(String.valueOf(lists.get(position).getGoods_price()));
        }
    }

    @Override
    public int getItemCount() {
        return lists == null ? 0 : lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView goodsPic;
        TextView goodsName;
        TextView goodsPrice;

        LinearLayout goods;

        private int position;

        public ViewHolder(View convertView) {
            super(convertView);
            AutoUtils.autoSize(convertView);
            goodsPic = (ImageView) convertView.findViewById(R.id.iv_focus_goods_img);
            goodsName = (TextView) convertView.findViewById(R.id.tv_focus_goods_name);
            goodsPrice = (TextView) convertView.findViewById(R.id.tv_focus_goods_price);
            goods = (LinearLayout) convertView.findViewById(R.id.ll_focus_goods);

            goods.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, GoodsDetailActivity.class);
                    intent.putExtra(Url.GOODS_ID, String.valueOf(lists.get(position).getGoods_id()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                    context.startActivity(intent);

                }
            });
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
