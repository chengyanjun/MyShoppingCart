package com.shopping.chengzi.myshoppingcart.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.activity.GoodsDetailActivity;
import com.shopping.chengzi.myshoppingcart.bean.BeanHomeGoodsList;
import com.shopping.chengzi.myshoppingcart.utils.LogUtil;
import com.shopping.chengzi.myshoppingcart.utils.Url;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by chengzi on 2017/3/8.
 */

public class HomeGoodsListGridViewAdapter extends BaseAdapter {

    private List<BeanHomeGoodsList.DatasBean.GoodsListBean> listBeen;
    private Context context;

    public HomeGoodsListGridViewAdapter(List<BeanHomeGoodsList.DatasBean.GoodsListBean> listBeen, Context context) {
        this.listBeen = listBeen;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return listBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_goods_list, viewGroup, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            AutoUtils.autoSize(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.setPosition(i);

        BeanHomeGoodsList.DatasBean.GoodsListBean goodsListBean = listBeen.get(i);
        viewHolder.goodsName.setText(goodsListBean.getGoods_name());

        viewHolder.goodsPrice.setText(goodsListBean.getGoods_price());
        //给图片加tag防止滑动闪烁
        Object tag = viewHolder.goodsPic.getTag();
        if (tag == null || (tag != null && !tag.equals(goodsListBean.getGoods_image_url()))) {
            ImageLoader.getInstance().displayImage(goodsListBean.getGoods_image_url(), viewHolder.goodsPic);
            viewHolder.goodsPic.setTag(goodsListBean.getGoods_image_url());
        }
        return convertView;
    }

    class ViewHolder implements View.OnClickListener {

        TextView goodsName;
        TextView goodsPrice;
        ImageView goodsPic;

        LinearLayout ll_my_tuijian_goods_gridview;

        int position;

        public ViewHolder(View view) {

            goodsName = (TextView) view.findViewById(R.id.tv_my_tuijian_goods_name);
            goodsPrice = (TextView) view.findViewById(R.id.tv_my_tuijian_goods_price);
            goodsPic = (ImageView) view.findViewById(R.id.iv_my_tuijian_goods_pic);
            ll_my_tuijian_goods_gridview = (LinearLayout) view.findViewById(R.id.ll_my_tuijian_goods_gridview);

            view.setOnClickListener(this);
            ll_my_tuijian_goods_gridview.setOnClickListener(this);

        }

        public void setPosition(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_my_tuijian_goods_gridview:
                    Intent intent = new Intent(context, GoodsDetailActivity.class);
                    intent.putExtra(Url.GOODS_ID, listBeen.get(position).getGoods_id());
                    LogUtil.i("商品"+listBeen.get(position).getGoods_id());
                    context.startActivity(intent);
                    break;
            }
        }
    }
}
