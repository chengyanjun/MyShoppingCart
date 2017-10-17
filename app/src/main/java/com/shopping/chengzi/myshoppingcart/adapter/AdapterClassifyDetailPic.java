package com.shopping.chengzi.myshoppingcart.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.activity.ClassifyGoodsListActivity;
import com.shopping.chengzi.myshoppingcart.bean.BeanClassifyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengzi on 2017/3/14.
 */

public class AdapterClassifyDetailPic extends BaseAdapter {

    private Context context;
    private List<BeanClassifyDetail.DatasBean.ClassListBean> beanList = new ArrayList<>();

    public AdapterClassifyDetailPic(Context context, List<BeanClassifyDetail.DatasBean.ClassListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int i) {
        return beanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    ViewHolder holder;

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_classify_detail_pic, viewGroup, false);
            holder = new ViewHolder(view, i);
            holder.setPosition(i);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        BeanClassifyDetail.DatasBean.ClassListBean bean = beanList.get(i);
        holder.goodsName.setText(bean.getGc_name());

        return view;
    }

    class ViewHolder implements View.OnClickListener {
        TextView goodsName;
        LinearLayout rightGoods;
        int position;

        public ViewHolder(View view, int position) {
            this.position = position;
            goodsName = (TextView) view.findViewById(R.id.tv_classify_detail_goods_name);
            rightGoods = (LinearLayout) view.findViewById(R.id.ll_right_classify_goods);
            rightGoods.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ll_right_classify_goods:
                    Intent intent = new Intent(context,ClassifyGoodsListActivity.class);
                    context.startActivity(intent);
                    break;
            }
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
