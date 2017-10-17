package com.shopping.chengzi.myshoppingcart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.bean.BeanHome;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by chengzi on 2017/3/9.
 */

public class HomeGoodsClassifyGridViewAdapter extends BaseAdapter {

    private List<BeanHome.DatasBean.Home3Bean.ItemBeanXX> home3BeanList;
    private Context context;

    public HomeGoodsClassifyGridViewAdapter(List<BeanHome.DatasBean.Home3Bean.ItemBeanXX> home3BeanList, Context context) {
        this.home3BeanList = home3BeanList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return home3BeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return home3BeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_goods_classify, viewGroup, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            AutoUtils.autoSize(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.setPosition(i);
        BeanHome.DatasBean.Home3Bean.ItemBeanXX home3Bean = home3BeanList.get(i);
        //给图片加tag防止滑动闪烁
        Object tag = viewHolder.goodsPic.getTag();
        if (tag == null || (tag != null && !tag.equals(home3Bean))) {
            ImageLoader.getInstance().displayImage(home3Bean.getImage(), viewHolder.goodsPic);
            viewHolder.goodsPic.setTag(home3Bean.getImage());
        }
        return convertView;
    }

    class ViewHolder {

        ImageView goodsPic;
        int position;

        public ViewHolder(View view) {
            goodsPic = (ImageView) view.findViewById(R.id.iv_home_goods_classify);
        }

        public void setPosition(int position) {
            this.position = position;
        }

    }
}
