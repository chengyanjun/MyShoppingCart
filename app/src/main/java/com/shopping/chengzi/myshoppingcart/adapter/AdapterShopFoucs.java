package com.shopping.chengzi.myshoppingcart.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.bean.BeanShopFocus;

import java.util.List;

/**
 * Created by chengzi on 2017/3/31.
 */

public class AdapterShopFoucs extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<BeanShopFocus.DatasBean.FavoritesListBean> lists;

    public AdapterShopFoucs(Context context, List<BeanShopFocus.DatasBean.FavoritesListBean> lists) {
        this.context = context;
        this.lists = lists;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop_goods,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.setPosition(position);

        if (lists != null) {
            ImageLoader.getInstance().displayImage(lists.get(position).getStore_avatar_url(), viewHolder.pic);
            viewHolder.name.setText(lists.get(position).getStore_name());
            viewHolder.focusTime.setText("收藏时间:" + lists.get(position).getFav_time_text());
        }
    }

    @Override
    public int getItemCount() {
        return lists == null ? 0 : lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView name;
        TextView focusTime;

        private int position;

        public ViewHolder(View view) {
            super(view);

           pic = (ImageView) view.findViewById(R.id.goods_pic);
           name = (TextView) view.findViewById(R.id.goods_name);
           focusTime = (TextView) view.findViewById(R.id.tv_focus_time);

        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
